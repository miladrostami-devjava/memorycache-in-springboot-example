package com.example.memorycache.services;

import com.example.memorycache.entity.User;

import java.util.List;

public interface UserService {

    User createUser(User user);
    User getUserById(Long id);
    List<User> getUsers();
    void updateUser(User user);
    void deleteUser(Long id);
    void deleteUsers();

}
