package org.example.service;

import org.example.model.User;
import org.example.repositories.UserRepository;

public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void addUser(String email, String password) {
        User userExisting = userRepository.findByEmail(email);

        if(userExisting != null) {
            throw new RuntimeException("Email already registered! ");
        }

        User user = new User(email, password);
        userRepository.addUser(user);
    }

    public boolean userLogin(String email, String password) {
        User user = userRepository.findByEmail(email);
        return user != null && user.getPassword().equals(password);
    }

}
