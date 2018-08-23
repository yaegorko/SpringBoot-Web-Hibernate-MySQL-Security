package com.example.springboot.service;

import com.example.springboot.entity.User;

import java.util.List;

public interface UserService {
    void add(User user);
    User getById(int id);
    User getByName(String name);
    void updateUser(User user);
    List<User> getAllUsers();
    void deleteUser(int id);
}
