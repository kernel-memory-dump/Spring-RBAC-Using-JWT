package co.decem.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import co.decem.model.OrderLine;


public interface OrderLineRepository extends JpaRepository<OrderLine, Long> {
    
}
