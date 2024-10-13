package com.jiaxin.carts.service;

import com.jiaxin.carts.model.CartItem;


import java.util.List;

public interface PriceCalculateService {
    double calculateTotalPrice(List<CartItem> cartItems);
}
