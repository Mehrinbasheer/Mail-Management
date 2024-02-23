package com.example.mail.Controller;

import com.example.mail.Services.UserService;
import com.example.mail.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {

        this.userService = userService;
    }

    @GetMapping("/getalluser")
    public List<User> getAllUsers() {

        return userService.getAllUsers();
    }

    @GetMapping("/userget/{userId}")
    public Optional<User> getUserById(@PathVariable Long userId) {

        return userService.getUserById(userId);
    }

    @PostMapping("/create")
    public User createUser(@RequestBody User user) {

        return userService.createUser(user);
    }

    @PutMapping("/userupdate/{userId}")
    public User updateUser(@PathVariable Long userId, @RequestBody User updatedUser) {
        return userService.updateUser(userId, updatedUser);
    }

    @DeleteMapping("/delete/{userId}")
    public String deleteUser(@PathVariable Long userId) {
        userService.deleteUser(userId);
        return " deleted successfully..";
    }
}


