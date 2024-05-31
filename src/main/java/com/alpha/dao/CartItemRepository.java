package com.alpha.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alpha.model.CartItem;


public interface CartItemRepository extends JpaRepository<CartItem, Long>{
    
}
