package org.example.service;

import org.example.model.User;
import org.example.repositories.UserRepository;

public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void addUser(String email, String password) {
        User user = new User(email, password);
        userRepository.addUser(user);
    }

}
