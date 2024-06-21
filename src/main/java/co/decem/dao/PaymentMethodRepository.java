package co.decem.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import co.decem.model.PaymentMethod;


public interface PaymentMethodRepository extends JpaRepository<PaymentMethod, Long> {
    
}
