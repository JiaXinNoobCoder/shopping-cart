package com.jiaxin.carts.dao;

import com.jiaxin.carts.model.CartItem;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartItemRepository extends org.springframework.data.repository.Repository<CartItem, Integer> {
    List<CartItem> findCartItemsByCartID(int cartID);

}
