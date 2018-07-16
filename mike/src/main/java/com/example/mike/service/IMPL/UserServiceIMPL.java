package com.example.mike.service.IMPL;

import com.example.mike.mapper.UserMapper;
import com.example.mike.model.User;
import com.example.mike.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service(value = "userService")
public class UserServiceIMPL implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User FindUser(int id) {
        return userMapper.selectByPrimaryKey(id);
    }
}
