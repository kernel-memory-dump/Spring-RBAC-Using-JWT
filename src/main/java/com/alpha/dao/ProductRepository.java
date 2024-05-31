package com.alpha.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alpha.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
    
}
