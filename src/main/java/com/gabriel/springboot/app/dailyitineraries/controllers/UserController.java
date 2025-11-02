package com.gabriel.springboot.app.dailyitineraries.controllers;

import com.gabriel.springboot.app.dailyitineraries.entities.User;
import com.gabriel.springboot.app.dailyitineraries.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {
    final private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<User>> findAll() {
        return ResponseEntity.ok(userService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id) {
        Optional<User> user = userService.findById(id);
        if (user.isPresent()) {
            return ResponseEntity.ok(user.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<User> save(@RequestBody User user) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(user));
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> update(@PathVariable Long id, @RequestBody User user) {
        Optional<User> userOptional = userService.findById(id);

        if (userOptional.isPresent()) {
            User userToUpdate = userOptional.orElseThrow();
            userToUpdate.setUsername(user.getUsername());
            userToUpdate.setPassword(user.getPassword());
            userToUpdate.setEmail(user.getEmail());

            return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(userToUpdate));
        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<User> delete(@PathVariable Long id) {
        Optional<User> user = userService.deleteById(id);
        if (user.isPresent()) {
            User userDeleted = user.orElseThrow();
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(userDeleted);
        }
        return ResponseEntity.notFound().build();
    }
}
