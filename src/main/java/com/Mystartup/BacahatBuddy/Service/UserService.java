package com.Mystartup.BacahatBuddy.Service;

import com.Mystartup.BacahatBuddy.Model.User;
import com.Mystartup.BacahatBuddy.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository repo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public UserService(UserRepository repo) {
        this.repo = repo;
    }

    public List<User> getAllUsers() {
        return repo.findAll();
    }

    public User getUserById(Long id) {
        return repo.findById(id).orElse(null);
    }

    public Optional<User> getUserByUsername(String username) {
        return repo.findByUsername(username);
    }

    public User createUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return repo.save(user);
    }

    public User updateUser(Long id, User userDetails) {
        User user = repo.findById(id).orElse(null);
        if (user != null) {
            user.setName(userDetails.getName());
            user.setEmail(userDetails.getEmail());
            return repo.save(user);
        }
        return null;
    }

    public User deleteUser(Long id) {
        User user = repo.findById(id).orElse(null);
        if (user != null) {
            repo.deleteById(id);
        }
        return user;
    }
}