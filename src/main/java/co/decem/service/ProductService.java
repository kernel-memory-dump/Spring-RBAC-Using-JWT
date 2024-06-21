package co.decem.service;

import co.decem.model.Product;

public interface ProductService {
    
    Product getProductById(Long id);

    Product createProduct(Product product);
}
