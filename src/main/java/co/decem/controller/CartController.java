package co.decem.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.decem.model.Cart;
import co.decem.model.CartDTO;
import co.decem.service.CartService;



@RestController
@RequestMapping("/api/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @PostMapping
    public ResponseEntity<Cart> addToCart(@RequestBody CartDTO cartDTO) {
        Cart createdCart = cartService.addToCart(cartDTO);
        return ResponseEntity.ok(createdCart);
    }
    
}
