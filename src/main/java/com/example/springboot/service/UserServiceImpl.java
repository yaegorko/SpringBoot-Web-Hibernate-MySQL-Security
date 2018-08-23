package com.example.springboot.service;

import com.example.springboot.dao.UserDAO;
import com.example.springboot.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserDAO userDAO;

    @Autowired
    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public void add(User user) {
        userDAO.addNewUser(user);
    }

    @Override
    public User getById(int id) {
        return userDAO.getUserUserById(id);
    }

    @Override
    public User getByName(String name) {
        return userDAO.getUserByName(name);
    }

    @Override
    public void updateUser(User user) {
        userDAO.updateUser(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userDAO.getAllUsers();
    }

    @Override
    public void deleteUser(int id) {
        userDAO.deleteUserById(id);
    }
}
