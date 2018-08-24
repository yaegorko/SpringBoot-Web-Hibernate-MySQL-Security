package com.example.springboot.dao;

import com.example.springboot.entity.User;

import java.util.List;

public interface UserDAO {
    void addNewUser(User user);
    User getUserUserById(long id);
    User getUserByName(String name);
    void updateUser(User user);
    List<User> getAllUsers();
    void deleteUserById(long id);
}
