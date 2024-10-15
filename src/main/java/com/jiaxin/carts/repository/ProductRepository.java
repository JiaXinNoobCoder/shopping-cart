package com.jiaxin.carts.repository;

import com.jiaxin.carts.entity.Product;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends org.springframework.data.repository.Repository<Product, Integer> {
    Product findProductByProductID(int productID);

}
