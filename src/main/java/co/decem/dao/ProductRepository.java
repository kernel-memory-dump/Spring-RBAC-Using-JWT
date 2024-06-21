package co.decem.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import co.decem.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
    
}
