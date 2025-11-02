package com.gabriel.springboot.app.dailyitineraries.services;

import com.gabriel.springboot.app.dailyitineraries.entities.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> findAll();
    Optional<User> findById(Long id);
    User save(User user);
    Optional<User> deleteById(Long id);
}
