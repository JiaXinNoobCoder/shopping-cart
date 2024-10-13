package com.jiaxin.carts.service.impl;

import com.jiaxin.carts.dao.UserRepository;
import com.jiaxin.carts.exception.ErrorCode;
import com.jiaxin.carts.exception.IllegalRequestException;
import com.jiaxin.carts.model.User;
import com.jiaxin.carts.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public User findUserByUserID(int userID) {
        return userRepository.findUserByUserID(userID).orElseThrow(() ->
                new IllegalRequestException(ErrorCode.ILLEGAL_REQUEST.getCode(), ErrorCode.ILLEGAL_REQUEST.getMessage())
        );
    }
}
