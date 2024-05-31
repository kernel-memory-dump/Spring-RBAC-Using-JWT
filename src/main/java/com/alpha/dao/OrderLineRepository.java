package com.alpha.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alpha.model.OrderLine;


public interface OrderLineRepository extends JpaRepository<OrderLine, Long> {
    
}
