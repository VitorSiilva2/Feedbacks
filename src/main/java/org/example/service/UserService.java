package org.example.service;

import org.example.model.User;
import org.example.repositories.UserRepository;

public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void addUser(String email, String password, String name) {
        User userExisting = userRepository.findByEmail(email);

        // Verifica se o email já está cadastrado, se sim lança uma exceção.
        if(userExisting != null) {
            throw new RuntimeException("Email already registered! ");
        }
        // Caso não cria uma conta.
        User user = new User(email, password, name);
        userRepository.addUser(user);
    }

    public boolean userLogin(String email, String password) {
        // Atraves da função findbyEmail busca o email do usuario.
        User user = userRepository.findByEmail(email);
        // Busca a senha do Usuario e verifica se é igual.
        return user != null && user.getPassword().equals(password);
    }

}
