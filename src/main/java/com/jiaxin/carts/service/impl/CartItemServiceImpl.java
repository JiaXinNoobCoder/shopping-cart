package com.jiaxin.carts.service.impl;


import com.jiaxin.carts.repository.CartItemRepository;
import com.jiaxin.carts.entity.CartItem;
import com.jiaxin.carts.service.CartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Collections;
import java.util.List;

@Service
public class CartItemServiceImpl implements CartItemService {
    @Autowired
    CartItemRepository cartItemRepository;

    @Override
    public List<CartItem> getCartItemByCartID(int cartID) {
        List<CartItem> cartItems = cartItemRepository.findCartItemsByCartID(cartID);
        if (cartItems == null) {
            return Collections.emptyList();
        }
        return cartItems;
    }

    @Override
    public CartItem getCartItemByCartIDAndProductID(int cartID, int productID) {
        return cartItemRepository.findCartItemByCartIDAndProductID(cartID, productID);
    }

    @Override
    public CartItem saveCartItem(CartItem cartItem) {
        return cartItemRepository.save(cartItem);
    }

}
