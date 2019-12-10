package com.exchange.used.services;

import com.exchange.used.configure.LayuiResult;
import com.exchange.used.entity.User;

import java.util.List;

public interface UserServiceI {
    LayuiResult login(String username,String password);
    boolean namever(String username);
    boolean add(User user);
    List<User> getAllUsers(String sql);
    int total(String sql);
}
