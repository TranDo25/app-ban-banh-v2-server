package com.example.appbanbanhv2.service;

import com.example.appbanbanhv2.entity.Cart;
import com.example.appbanbanhv2.entity.ChiTietOrder;
import com.example.appbanbanhv2.entity.Orders;
import com.example.appbanbanhv2.entity.Products;
import com.example.appbanbanhv2.repository.ChiTietOrderRepository;
import com.example.appbanbanhv2.repository.OrdersRepository;

import org.springframework.beans.factory.annotation.Autowired;
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
                ChiTietOrder chiTietOrder = new ChiTietOrder();
                int countRecordInChiTietOrder = (int) _chiTietOrderRepository.count();
                if(countRecordInChiTietOrder == 0){
                    chiTietOrder.setId(1);
                }
                else{
                    int theLastestChiTietOrderId = _chiTietOrderRepository.getTheLastestId()+1;
                    chiTietOrder.setId(theLastestChiTietOrderId);
                }
                chiTietOrder.setCartId(i.getId());
                chiTietOrder.setOrdersId(order.getId());
                _chiTietOrderRepository.save(chiTietOrder);
            }


            res = "successful";
        } catch (Exception e) {
            res = "error in create order";
        } return res;

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
        if(orders.isPresent())
        {
            Orders tmp = orders.get();
            tmp.setMomoToken(token);
            try {
                ordersRepository.save(tmp);
                message = "set token successful";
            } catch (Exception e) {
                message = "error in set token";
            }
        }
        else  message = "not find orders";


        return message ;
    }

    @Override
    public String setTrangThaiDonHang(int idOrder, Integer codeStatus) {
        String message = "";

        Optional<Orders> orders = ordersRepository.findById((long) idOrder);
        if(orders.isPresent())
        {   String status = "";
            Orders tmp = orders.get();
            switch (codeStatus){
                case 1: status= status+"delivered";

                case 2: status= status+"delivering";

                case 3: status= status+"pending";

                case 4: status= status+"cancel";

                default: status= "create";
            }
            tmp.setTrangThaiDonHang(status);
            try {
                ordersRepository.save(tmp);
                message = "set trangThaiDonHang successful";
            } catch (Exception e) {
                message = "error in set trangThaiDonHang ";
            }
        }
        else  message = "not find orders";


        return message ;
    }

}