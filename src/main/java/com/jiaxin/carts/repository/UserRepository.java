package com.jiaxin.carts.repository;


import com.jiaxin.carts.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends org.springframework.data.repository.Repository<User, Integer> {
    User findUserByUserID(int userID);

}
