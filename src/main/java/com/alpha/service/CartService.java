package com.alpha.service;


import java.util.List;

import com.alpha.model.Cart;
import com.alpha.model.CartDTO;



public interface CartService {

    List<Cart> getCartWithinTimeInterval();

    Cart addToCart(CartDTO cartDTO);
    
}
