package com.jiaxin.carts.repository;

import com.jiaxin.carts.entity.CartItem;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CartItemRepository extends org.springframework.data.repository.CrudRepository<CartItem, Integer> {
    List<CartItem> findCartItemsByCartID(int cartID);

    CartItem findCartItemByCartIDAndProductID(int cartID, int productID);
}
