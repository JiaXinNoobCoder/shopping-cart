package com.jiaxin.carts.service.impl;

import com.jiaxin.carts.dao.CartRepository;
import com.jiaxin.carts.exception.ErrorCode;
import com.jiaxin.carts.exception.IllegalRequestException;
import com.jiaxin.carts.model.Cart;
import com.jiaxin.carts.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class CartServiceImpl implements CartService {
    @Autowired
    private CartRepository cartRepository;
    @Override
    public Cart getCartByUserID(int userID) {
        return cartRepository.getCartByUserID(userID).orElseThrow(() ->
            new IllegalRequestException(ErrorCode.ILLEGAL_REQUEST.getCode(), ErrorCode.ILLEGAL_REQUEST.getMessage())
        );
    }
}
