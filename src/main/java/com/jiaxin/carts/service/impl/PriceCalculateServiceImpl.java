package com.jiaxin.carts.service.impl;

import com.jiaxin.carts.entity.CartItem;
import com.jiaxin.carts.service.PriceCalculateService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PriceCalculateServiceImpl implements PriceCalculateService {
    private static final double PER_CENT_UNITS = 100.00;


    @Override
    public double calculateTotalPrice(List<CartItem> cartItems) {
        long totalPriceWithFen = 0;
        for (CartItem cartItem: cartItems) {
            totalPriceWithFen += cartItem.getPrice() * cartItem.getQuantity();
        }
        return totalPriceWithFen / PER_CENT_UNITS;
    }
}
