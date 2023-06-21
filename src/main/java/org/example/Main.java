package org.example;

import org.example.controller.PersonController;
import org.example.controller.UserController;
import org.example.db.DB;
import org.example.model.User;
import org.example.repositories.PersonRepository;
import org.example.repositories.UserRepository;
import org.example.service.PersonService;
import org.example.service.UserService;

public class Main {
    public static void main(String[] args) {

        UserRepository userRepository = new UserRepository(DB.getConnection());
        UserService userService = new UserService(userRepository);
        UserController userController = new UserController(userService);

        userController.addUser("camila@gmail.com", "Mila@2023$$", 64);



    }
}