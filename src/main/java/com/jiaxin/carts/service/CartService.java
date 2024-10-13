package com.jiaxin.carts.service;

import com.jiaxin.carts.model.Cart;
public interface CartService {
    Cart getCartByUserID(int userID);
}
