package com.example.mail.Services;

import com.example.mail.entity.User;
import com.example.mail.repository.Userrepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class
UserService {
    private final Userrepo userrepo;

    @Autowired
    public UserService(Userrepo userrepo) {
        this.userrepo = userrepo;
    }

    public List<User> getAllUsers() {
        return userrepo.findAll();
    }

    public Optional<User> getUserById(Long userId) {
        return userrepo.findById(userId);
    }

    public User createUser(User user) {
        return userrepo.save(user);
    }

    public User updateUser(Long userId, User updatedUser) {
        Optional<User> existingUser = userrepo.findById(userId);
        if (existingUser.isPresent()) {
            User userToUpdate = existingUser.get();
            userToUpdate.setUsername(updatedUser.getUsername());
            userToUpdate.setPassword(updatedUser.getPassword());
            userToUpdate.setEmail(updatedUser.getEmail());
            return userrepo.save(userToUpdate);
        } else {
            return null;
        }
    }

    public void deleteUser(Long userId) {
        userrepo.deleteById(userId);
    }
}
