package com.dev.simplecrudapp.controller;

import com.dev.simplecrudapp.User;
import com.dev.simplecrudapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserRepository userRepository;

    @GetMapping("/all")
    public List<User> getAllUsers() {
        System.out.println("Działa");
        return userRepository.getAllUsers();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable("id") int id) {
        return userRepository.getUserById(id);
    }

    @DeleteMapping("/remove/{id}")
    public void deleteUserById(@PathVariable("id") int id) {
        userRepository.removeUserById(id);
    }

    @PostMapping("/add")
    public void addUser(@RequestBody List<User> users) {
        userRepository.addNewUsers(users);
    }
}
