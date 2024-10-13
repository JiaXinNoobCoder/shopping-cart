package com.jiaxin.carts.dao;

import com.jiaxin.carts.model.Product;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends org.springframework.data.repository.Repository<Product, Integer> {
    // Optional<Product> findProductByProductID();

}
