package co.decem.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import co.decem.model.CartItem;


public interface CartItemRepository extends JpaRepository<CartItem, Long>{
    
}
