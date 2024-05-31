package com.alpha.service;

import com.alpha.model.Product;

public interface ProductService {
    
    Product getProductById(Long id);

    Product createProduct(Product product);
}
