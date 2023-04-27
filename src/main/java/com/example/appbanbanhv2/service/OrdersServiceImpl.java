package com.example.appbanbanhv2.service;

import com.example.appbanbanhv2.dto.ChiTietOrderDTO;
import com.example.appbanbanhv2.dto.MessageDTO;
import com.example.appbanbanhv2.entity.Cart;
import com.example.appbanbanhv2.entity.ChiTietOrder;
import com.example.appbanbanhv2.entity.Orders;
import com.example.appbanbanhv2.entity.Products;
import com.example.appbanbanhv2.repository.CartRepository;
import com.example.appbanbanhv2.repository.ChiTietOrderRepository;
import com.example.appbanbanhv2.repository.OrdersRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Service
public class OrdersServiceImpl implements OrdersService {
    @Autowired
    private ProductsService _proService;
    @Autowired
    private OrdersRepository ordersRepository;
    @Autowired
    private ChiTietOrderRepository _chiTietOrderRepository;
    @Autowired
    private CartRepository _cartRepository;

    @Override
    public Orders save(Orders orders) {
        return ordersRepository.save(orders);
    }

    @Override
    public Optional<Orders> find(Long id) {
        return ordersRepository.findById(id);
    }

    @Override
    public List<Orders> findAll() {
        return ordersRepository.findAll();
    }

    @Override
    public List<Orders> findAll(Sort sort) {
        return ordersRepository.findAll(sort);
    }

    @Override
    public Page<Orders> findAll(Pageable pageable) {
        return ordersRepository.findAll(pageable);
    }

    @Override
    public void delete(Long id) {
        ordersRepository.deleteById(id);
    }

    @Override
    public void delete(Orders orders) {
        ordersRepository.delete(orders);
    }

    @Override
    public void deleteAll() {
        ordersRepository.deleteAll();
    }

    @Override
    public long count() {
        return ordersRepository.count();
    }

    @Override
    public String createOrder(List<Cart> dsCart) {
        Orders order = new Orders();
        int count = (int) ordersRepository.count();
        if (count == 0) {
            order.setId(1);
        } else {
            int theLastestId = (int) ordersRepository.getTheLastestId() + 1;
            order.setId(theLastestId);
        }

        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        order.setNgayTaoDon(currentDate.format(formatter));
        double tongTienDonHang = 0;
        for (Cart i : dsCart) {
            Products tmp = _proService.find(i.getProductsId()).get();
            double tongTien = tmp.getGia() * i.getSoluong();
            tongTienDonHang += tongTien;
        }
        order.setTongtien(tongTienDonHang);
        order.setTrangThaiDonHang("created");
        String res = "";
        try {
            ordersRepository.save(order);
            for (Cart i : dsCart) {
                i.setIsChecked(true);
                _cartRepository.save(i);
                ChiTietOrder chiTietOrder = new ChiTietOrder();
                int countRecordInChiTietOrder = (int) _chiTietOrderRepository.count();
                if (countRecordInChiTietOrder == 0) {
                    chiTietOrder.setId(1);
                } else {
                    int theLastestChiTietOrderId = _chiTietOrderRepository.getTheLastestId() + 1;
                    chiTietOrder.setId(theLastestChiTietOrderId);
                }
                chiTietOrder.setCartId(i.getId());
                chiTietOrder.setOrdersId(order.getId());
                _chiTietOrderRepository.save(chiTietOrder);
            }


            res = String.valueOf(ordersRepository.getTheLastestId());
        } catch (Exception e) {
            res = "error";
        }
        return res;

    }

    @Override
    public String setThongTinGiaoHang(int idOrder, String sdt, String diaChiGiaoHang) {
        String message = "";
        Optional<Orders> tmp2 = ordersRepository.findById((long) idOrder);
        if (tmp2.isPresent()) {
            Orders tmp = tmp2.get();
            tmp.setSdt(sdt);
            tmp.setDiachigiaohang(diaChiGiaoHang);

            try {
                ordersRepository.save(tmp);
                message = "set info successful";
            } catch (Exception e) {
                message = "error in set info";
            }
        } else {
            message = "cannot find order";
        }

        return message;
    }

    @Override
    public String setToken(int idOrder, String token) {
        String message = "";
        Optional<Orders> orders = ordersRepository.findById((long) idOrder);
        if (orders.isPresent()) {
            Orders tmp = orders.get();
            tmp.setMomoToken(token);
            try {
                ordersRepository.save(tmp);
                message = "set token successful";
            } catch (Exception e) {
                message = "error in set token";
            }
        } else message = "not find orders";


        return message;
    }

    @Override
    public String setTrangThaiDonHang(int idOrder, Integer codeStatus) {
        String message = "";

        Optional<Orders> orders = ordersRepository.findById((long) idOrder);
        if (orders.isPresent()) {
            String status = "";
            Orders tmp = orders.get();
            switch (codeStatus) {
                case 0:
                    status = "paid";
                    break;

                case 1:
                    status = "delivered";
                    break;
                case 2:
                    status = "delivering";
                    break;
                case 3:
                    status = "pending";
                    break;
                case 4:
                    status = "cancel";
                    break;
                default:
                    status = "created";
            }
            tmp.setTrangThaiDonHang(status);
            try {
                ordersRepository.save(tmp);
                message = "set trangThaiDonHang successful";
            } catch (Exception e) {
                message = "error in set trangThaiDonHang ";
            }
        } else message = "not find orders";


        return message;
    }

    @Override
    public ChiTietOrderDTO getChiTietOrder(int idOrder) {
        ChiTietOrderDTO chiTietOrderDTO = new ChiTietOrderDTO();
        Optional<Orders> tmp = ordersRepository.findById((long) idOrder);
        if (tmp.isPresent()) {
            Orders orders = tmp.get();
            List<ChiTietOrder> chiTietOrderList = _chiTietOrderRepository.findByOrdersId(orders.getId());
            chiTietOrderDTO.setOrders(orders);
            chiTietOrderDTO.setChiTietOrderList(chiTietOrderList);

        }
        return chiTietOrderDTO;


    }

    @Override
    public MessageDTO getTheNewestOrderId() {
        int theNewestOrderId = ordersRepository.getTheLastestId();
        MessageDTO dto = new MessageDTO(String.valueOf(theNewestOrderId));
        return dto;
    }

    @Override
    public List<Orders> getOrderByIdUser(String idUser) {
        return ordersRepository.getOrderByIdUser(idUser);
    }

}