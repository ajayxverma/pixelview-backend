package com.airexus.pixelview.service;

import com.airexus.pixelview.entities.User;
import com.airexus.pixelview.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    // This service can interact with the UserRepository to perform database operations.

    @Autowired
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    // Example method to create a new user
    public void createUser(String username, String password) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        userRepository.save(user);
    }
}
