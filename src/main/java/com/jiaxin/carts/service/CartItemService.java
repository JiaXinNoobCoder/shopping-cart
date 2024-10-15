package com.jiaxin.carts.service;

import com.jiaxin.carts.entity.CartItem;

import java.util.List;

public interface CartItemService {
    List<CartItem> getCartItemByCartID(int cartID);

    CartItem getCartItemByCartIDAndProductID(int cartID, int productID);

    CartItem saveCartItem(CartItem cartItem);

}
