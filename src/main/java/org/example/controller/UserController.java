package org.example.controller;

import org.example.service.UserService;

public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    public void addUser(String email, String password) {
        userService.addUser(email, password);

    }

    public void userLogin(String email, String password) {
        boolean loginSucces = userService.userLogin(email, password);
        if (loginSucces){
            System.out.println("Logado com succeso");
        } else {
            System.out.println("Email ou senha invalida");
        }
    }
}
