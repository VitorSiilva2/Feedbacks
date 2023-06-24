package org.example.controller;

import org.example.service.UserService;
import org.example.util.EmailValidator;

public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    public void addUser(String email, String password, String name) {
        if(EmailValidator.emailValidator(email)) {
            userService.addUser(email, password, name);
        } else {
            System.out.println("Email invalido");
        }

    }

    public void userLogin(String email, String password) {

        if (EmailValidator.emailValidator((email))) {
            boolean loginSucces = userService.userLogin(email, password);
            if (loginSucces) {
                System.out.println("Logado com succeso");
            } else {
                System.out.println("Email ou senha invalida");
            }
        } else {
            System.out.println("Dígite um formato de email valido");
        }
    }
}
