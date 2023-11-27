package com.example.katapp_boot.service;

import com.example.katapp_boot.entity.User;

import java.util.List;

public interface UserService {
    List<User> getListUsers();
    User getUser(Long id);
    void addUser(User user);
    void editUser(User user);
    void deleteUser(Long id);
}
