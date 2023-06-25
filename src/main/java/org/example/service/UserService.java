package org.example.service;

import org.example.model.User;
import org.example.repositories.UserRepository;
import org.example.util.EmailValidator;
import org.example.util.PasswordHasher;
import org.example.util.PasswordVerifier;

public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void addUser(String email, String password, String name) {

        if (!EmailValidator.emailValidator(email)) {
            throw new RuntimeException("Invalid email format! ");
        }
        User userExisting = userRepository.findByEmail(email);
        // Verifica se o email já está cadastrado, se sim lança uma exceção.
        if (userExisting != null) {
            throw new RuntimeException("Email already registered! ");
        }


        String passwordHash = new PasswordHasher().hashPassword(password);
        // Caso não cria uma conta.
        User user = new User(email, passwordHash, name);
        userRepository.addUser(user);
    }

    public boolean userLogin(String email, String password) {
        User user = userRepository.findByEmail(email);
        PasswordVerifier passwordVerifier = new PasswordVerifier();

        if (user != null) {
            // Verifica se a senha fornecida corresponde ao hash armazenado.
            return passwordVerifier.verifierPassword(password, user.getPassword());
        } else {
            return false; // Caso o não encontre o user.
        }
    }
}
