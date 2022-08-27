package com.droege.fitnesstracker.controller;

import com.droege.fitnesstracker.model.User;
import com.droege.fitnesstracker.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/add")
    public String add(@RequestBody User user) {
        userService.saveUser(user);
        return "User added";
    }

    @GetMapping("/getAll")
    public List<User> getAll() {
        return userService.getAllUsers();

    }
}
