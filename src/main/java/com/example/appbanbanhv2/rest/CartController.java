package com.example.appbanbanhv2.rest;

import com.example.appbanbanhv2.dto.MessageDTO;
import com.example.appbanbanhv2.dto.ProductAddToCartDTO;
import com.example.appbanbanhv2.dto.ProductWithImageWithNumberDTO;
import com.example.appbanbanhv2.entity.Cart;
import com.example.appbanbanhv2.entity.Users;
import com.example.appbanbanhv2.modelfrontend.GioHangModel;
import com.example.appbanbanhv2.repository.OrdersRepository;
import com.example.appbanbanhv2.repository.UsersRepository;
import com.example.appbanbanhv2.service.CartService;
import com.example.appbanbanhv2.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("")

public class CartController {

    @Autowired
    private CartService cartService;


    @PostMapping("/cart")
    public Cart save(@RequestBody Cart cart) {
        return cartService.save(cart);
    }

    // Tuấn anh viết
    // api thêm mới sản phẩm vào giỏ hàng


    @GetMapping("/cart/{id}")
    public Optional<Cart> getById(@PathVariable(value = "id") Long id) {
        return cartService.find(id);
    }

    //thay đổi số lượng của cart item trong giỏ hàng
    @GetMapping("/cart/changeNumberOfItem")
    public ResponseEntity<MessageDTO> changeNumberOfItem(@RequestParam("cartId") int cartId, @RequestParam("soluong") int soluong) {
        String res = cartService.changeNumberOfItem(cartId, soluong);
        MessageDTO dto = new MessageDTO(res);

        return ResponseEntity.ok(dto);
    }

    //api get giỏ hàng theo id user
    @GetMapping("/cart/getCartByIdUser")
    public ResponseEntity<List<ProductWithImageWithNumberDTO>> getCartByIdUser(@RequestParam("iduser") String iduser) {
        List<ProductWithImageWithNumberDTO> res = cartService.getGioHangByIdUser(iduser);
        return ResponseEntity.ok(res);
    }

    //api add sản phẩm vào giỏ hàng
    @PostMapping("/cart/addProductToCart")
    public ResponseEntity<MessageDTO> addProductToCart(@RequestBody ProductAddToCartDTO productAddToCartDTO) {
        MessageDTO res = new MessageDTO();
        String tmp = cartService.addProductToCart(
                productAddToCartDTO.getIdUser(),
                productAddToCartDTO.getIdProduct(),
                productAddToCartDTO.getSoLuong()
        );
        res.setMessage(tmp);
        return ResponseEntity.ok(res);
    }

    @GetMapping("/cart")
    public List<Cart> getAll() {
        return cartService.findAll();
    }

    @DeleteMapping("/cart")
    public String deleteById(@RequestParam("id") Long id) {
        cartService.delete(id);
        return "xoa gio hang thanh cong";
    }

    @GetMapping("/cart/getListCartByIdUserNew")
    public ResponseEntity<List<Cart>> getListCartByIdUserNew(@RequestParam("idUser") String idUser) {
        List<Cart> res = cartService.getListCartByIdUserNew(idUser);
        return ResponseEntity.ok(res);

    }

//	@DeleteMapping("/cart")
//	public void deleteAll() {
//		cartService.deleteAll();
//	}

    @GetMapping("/cart/count")
    public long count() {
        return cartService.count();
    }

    //xóa sản phẩm trong giỏ hàng
    @GetMapping("/cart/deleteCartItem")
    public ResponseEntity<MessageDTO> deleteCartItemById(@RequestParam("idCart") int idCart) {
        MessageDTO dto;
        try {
            cartService.delete((long) idCart);
            dto = new MessageDTO("delete succesfully");
        } catch (Exception e) {
            dto = new MessageDTO("delete error");

        }
        return ResponseEntity.ok(dto);
    }
}