package com.example.appbanbanhv2.service;


import com.example.appbanbanhv2.dto.ProductWithImageDTO;
import com.example.appbanbanhv2.dto.ProductWithImageWithNumberDTO;
import com.example.appbanbanhv2.entity.Cart;
import com.example.appbanbanhv2.entity.Products;
import com.example.appbanbanhv2.modelfrontend.GioHangModel;
import com.example.appbanbanhv2.repository.CartRepository;
import com.example.appbanbanhv2.repository.ProductsRepository;

import com.example.appbanbanhv2.repository.StorageRepository;
import com.example.appbanbanhv2.util.ServerConfig;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CartServiceImpl implements CartService {
    @Autowired
    private StorageRepository _stoRerpo;
    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private ProductsRepository proRepo;

    @Override
    public Cart save(Cart cart) {
        return cartRepository.save(cart);
    }

    @Override
    public Optional<Cart> find(Long id) {
        return cartRepository.findById(id);
    }

    @Override
    public List<Cart> findAll() {
        return cartRepository.findAll();
    }

    @Override
    public List<Cart> findAll(Sort sort) {
        return cartRepository.findAll(sort);
    }

    @Override
    public Page<Cart> findAll(Pageable pageable) {
        return cartRepository.findAll(pageable);
    }

    @Override
    public void delete(Long id) {
        cartRepository.deleteById(id);
    }

    @Override
    public void delete(Cart cart) {
        cartRepository.delete(cart);
    }

    @Override
    public void deleteAll() {
        cartRepository.deleteAll();
    }

    @Override
    public long count() {
        return cartRepository.count();
    }

    @Override
    public List<ProductWithImageWithNumberDTO> getGioHangByIdUser(String idUser) {
        List<Cart> dsMatHangTrongGio = cartRepository.findAllByUserId(idUser);
        List<ProductWithImageWithNumberDTO> res = new ArrayList<>();
        for (Cart i : dsMatHangTrongGio) {
            Products tmp = proRepo.findById(i.getProductsId()).get();
            ProductWithImageWithNumberDTO pDto = new ProductWithImageWithNumberDTO();
            ProductWithImageDTO tmpProWithImg = pDto.getProductWithImageDTO();
            BeanUtils.copyProperties(tmp,tmpProWithImg);
            pDto.getProductWithImageDTO().setImageName(ServerConfig.SERVER_IP_V4+ "api/admin/product/image/"+_stoRerpo.getImageNameByIdProduct(i.getProductsId()));
            pDto.setSoLuongMuonMua(i.getSoluong());
            pDto.setCartId(i.getId());
            res.add(pDto);
        }
        return res;
    }

    @Override
    public Cart findById(int cartId) {
        return cartRepository.findById((long) cartId).get();
    }

    @Override
    public String changeNumberOfItem(int cartId, int soluong) {
        Cart tmp = cartRepository.findById((long) cartId).get();
        tmp.setSoluong(soluong);
        String res = "";
        try {
            cartRepository.save(tmp);
            res += "successful";

        } catch (Exception e) {
            res += "error in change number of cart item";
        }
        return res;
    }

    @Override
    public String addProductToCart(String iduser, int idProduct, int soluong) {
        Cart tmp = new Cart();
        long count = cartRepository.count();
        int id ;
        if(count == 0){
            id = 1;
            tmp.setId(1);
        }
        else{
            id = (int) cartRepository.getNewestProductId()+1;
            tmp.setId(id);
        }
        tmp.setSoluong(soluong);
        tmp.setProductsId(idProduct);
        tmp.setUsersId(iduser);
        tmp.setIsChecked(true);
        String message = "";
        try{
            cartRepository.save(tmp);
            message = "add to cart successfully";
        }
        catch (Exception e){
            message = "error in add product to cart";
        }
        return message;
    }

    @Override
    public List<Cart> getListCartByIdUserNew(String idUser) {
        return cartRepository.getListCartByIdUserNew(idUser);
    }


}