package com.jiaxin.carts.results;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.jiaxin.carts.entity.CartItem;
import lombok.Data;
import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CartItemsListResult {
    @JsonProperty("user_name")
    private String userName;

    @JsonProperty("total_price")
    private double totalPrice;

    @JsonProperty("cart_items")
    private List<CartItem> cartItems;

    public CartItemsListResult(String userName, double totalPrice, List<CartItem> cartItems) {
        this.userName = userName;
        this.totalPrice = totalPrice;
        this.cartItems = cartItems;
    }
}
