package com.droege.fitnesstracker.service;

import com.droege.fitnesstracker.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    public User saveUser(User user);

    public List<User> getAllUsers();

    public Optional<User> findById(Integer userId);
}
