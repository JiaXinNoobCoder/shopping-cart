package com.jiaxin.carts.service.impl;

import com.jiaxin.carts.common.base.AppChecker;
import com.jiaxin.carts.repository.UserRepository;
import com.jiaxin.carts.entity.User;
import com.jiaxin.carts.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public User findUserByUserID(int userID) {
        AppChecker.assertPositive(userID);
        User user = userRepository.findUserByUserID(userID);
        AppChecker.assertNotNull(user);
        return user;
    }
}
