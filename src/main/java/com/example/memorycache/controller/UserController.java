package com.example.memorycache.controller;


import com.example.memorycache.entity.User;
import com.example.memorycache.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vi/cache")
public class UserController {

    private final UserService service;

    @Autowired
    public UserController(UserService service) {
        this.service = service;
    }


    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User createUser = service.createUser(user);
        return ResponseEntity.ok(createUser);
    }

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        User user = service.getUserById(id);
        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public ResponseEntity<List<User>> getUsers() {
        List<User> users = service.getUsers();
        return ResponseEntity.ok(users);
    }


    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public ResponseEntity<Void> updateUser(@RequestBody User user) {
        service.updateUser(user);
        return ResponseEntity.noContent().build();
    }


    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        service.deleteUser(id);
        return ResponseEntity.noContent().build();

    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteUsers() {
        service.deleteUsers();
        return ResponseEntity.noContent().build();
    }

}
