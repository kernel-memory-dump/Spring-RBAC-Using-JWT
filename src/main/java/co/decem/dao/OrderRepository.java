package co.decem.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import co.decem.model.Order;


public interface OrderRepository extends JpaRepository<Order, Long> {

    @Query("SELECT o FROM Order o LEFT JOIN FETCH o.orderLines ol LEFT JOIN FETCH ol.product WHERE o.id = :id")
    Optional<Order> findByIdWithOrderLinesAndProducts(@Param("id") Long id);
    
}
