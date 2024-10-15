package com.jiaxin.carts.service;

import com.jiaxin.carts.entity.Product;

public interface ProductService {
    Product findProductByProductID(int productID);
}
