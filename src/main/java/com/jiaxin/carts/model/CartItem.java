package com.jiaxin.carts.model;


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
    private Integer cartItemID;

    @Column(name = "cart_id")
    private Integer cartID;

    @Column(name = "product_id")
    private Integer productID;

    @Column(name = "product_name")
    private Integer productName;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "price")
    private long price;
}
