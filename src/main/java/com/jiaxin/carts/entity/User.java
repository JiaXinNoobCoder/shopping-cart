package com.jiaxin.carts.entity;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

/**
 * 用户实体类
 * */
@Entity
@Table(name = "\"user\"", schema = "shopping_cart")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int userID;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "email")
    private String email;
}
