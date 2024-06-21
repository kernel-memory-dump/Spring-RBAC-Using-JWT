package co.decem.dao;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import co.decem.model.Cart;



public interface CartRepository extends JpaRepository<Cart, Long> {

    @Query("SELECT c FROM Cart c WHERE c.dateCreated BETWEEN :startTime AND :endTime")
    List<Cart> findCartWithinTimeInterval(LocalDateTime startTime, LocalDateTime endTime);
    
}
