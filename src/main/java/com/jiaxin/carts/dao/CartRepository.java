package com.jiaxin.carts.dao;

import com.jiaxin.carts.model.Cart;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CartRepository extends org.springframework.data.repository.Repository<Cart, Integer> {
    Optional<Cart> getCartByUserID(int userID);

}
