package com.example.appbanbanhv2.service;


import com.example.appbanbanhv2.entity.Cart;
import com.example.appbanbanhv2.entity.Products;
import com.example.appbanbanhv2.modelfrontend.GioHangModel;
import com.example.appbanbanhv2.repository.CartRepository;
import com.example.appbanbanhv2.repository.ProductsRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

@Service
public class CartServiceImpl implements CartService {

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
    public List<Cart> findAll(Sort sort){
        return cartRepository.findAll(sort);
    }

    @Override
    public Page<Cart> findAll(Pageable pageable){
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
	public GioHangModel getGioHangByIdUser(String idUser) {
		List<Cart> dsMatHangTrongGio = cartRepository.findAllByUserId(idUser);
		GioHangModel res = new GioHangModel();
		for(Cart i: dsMatHangTrongGio) {
			Products tmp = proRepo.findById(i.getProductsId()).get();
			res.getDsMatHangTrongGio().add(tmp);
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
			
		}catch(Exception e) {
			res += "error in change number of cart item";
		}
		return res;
	}

	
	

}