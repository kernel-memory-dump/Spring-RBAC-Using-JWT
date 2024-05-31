package com.alpha.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alpha.model.PaymentMethod;


public interface PaymentMethodRepository extends JpaRepository<PaymentMethod, Long> {
    
}
