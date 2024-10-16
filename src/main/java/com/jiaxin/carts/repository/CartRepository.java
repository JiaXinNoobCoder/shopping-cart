package com.jiaxin.carts.repository;

import com.jiaxin.carts.entity.Cart;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends org.springframework.data.repository.Repository<Cart, Integer> {
    Cart getCartByUserIDAndCartID(int userID, int cartID);

    Cart getCartByUserID(int userID);

}
