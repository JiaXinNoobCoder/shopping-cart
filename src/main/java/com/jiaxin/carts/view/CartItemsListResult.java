package com.jiaxin.carts.view;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.jiaxin.carts.entity.CartItem;
import lombok.Data;
import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CartItemsListResult {
    @JsonProperty("belong_to")
    private String belongTo;

    @JsonProperty("total_price")
    private double totalPrice;

    @JsonProperty("cart_items")
    private List<CartItem> cartItems;

    public CartItemsListResult(String belongTo, double totalPrice, List<CartItem> cartItems) {
        this.belongTo = belongTo;
        this.totalPrice = totalPrice;
        this.cartItems = cartItems;
    }
}
