package com.jiaxin.carts.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

/**
 * 购物车物品实体类
 * */
@Entity
@Table(name = "cart_item", schema = "shopping_cart")
@Data
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cart_item_id")
    private int cartItemID;

    @Column(name = "cart_id")
    private int cartID;

    @Column(name = "product_id")
    private int productID;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "price")
    private long price;

    protected CartItem() {}
    private CartItem(Builder builder) {
        this.cartItemID = builder.cartItemID;
        this.cartID = builder.cartID;
        this.productID = builder.productID;
        this.productName = builder.productName;
        this.quantity = builder.quantity;
        this.price = builder.price;
    }

    public static class Builder {
        private int cartItemID;
        private int cartID;
        private int productID;
        private String productName;
        private int quantity;
        private long price;
        public Builder setCartItemID(int cartItemID) {
            this.cartItemID = cartItemID;
            return this;
        }

        public Builder setCartID(int cartID) {
            this.cartID = cartID;
            return this;
        }

        public Builder setProductID(int productID) {
            this.productID = productID;
            return this;
        }

        public Builder setProductName(String productName) {
            this.productName = productName;
            return this;
        }

        public Builder setQuantity(int quantity) {
            this.quantity = quantity;
            return this;
        }

        public Builder setPrice(long price) {
            this.price = price;
            return this;
        }

        public CartItem build() {
            return new CartItem(this);
        }
    }
}
