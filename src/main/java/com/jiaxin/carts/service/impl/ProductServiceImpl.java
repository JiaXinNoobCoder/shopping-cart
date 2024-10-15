package com.jiaxin.carts.service.impl;

import com.jiaxin.carts.common.base.AppChecker;
import com.jiaxin.carts.repository.ProductRepository;
import com.jiaxin.carts.entity.Product;
import com.jiaxin.carts.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product findProductByProductID(int productID) {
        Product product = productRepository.findProductByProductID(productID);
        AppChecker.assertNotNull(product);
        return product;
    }
}
