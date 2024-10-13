package com.jiaxin.carts.view;

import com.jiaxin.carts.model.CartItem;
import lombok.Data;

import java.util.List;
@Data
public class CartItemsListResult {
    private String belongTo;

    private double totalPrice;

    private List<CartItem> cartItems;
}
