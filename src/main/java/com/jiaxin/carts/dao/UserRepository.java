package com.jiaxin.carts.dao;


import com.jiaxin.carts.model.User;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends org.springframework.data.repository.Repository<User, Integer> {
    Optional<User> findUserByUserID(int userID);

}
