package org.example.util;

import org.junit.jupiter.api.Assertions;
import org.mindrot.jbcrypt.BCrypt;

class PasswordVerifierTest {

    // Teste para verificação de senha e hash correto.
    @org.junit.jupiter.api.Test
    void testVerifierCorrectPassword() {
        String password = "12345678";
        String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt());

        PasswordVerifier passwordVerifier = new PasswordVerifier();

        boolean result = passwordVerifier.verifierPassword(password, hashedPassword);

        Assertions.assertTrue(result);
    }

    // Teste para verificação de senha incorreta e hash correto.
    @org.junit.jupiter.api.Test
    void testVerifierIncorrectPassword() {
        String password = "12345678";
        String incorrectPassword = "1234";
        String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt());

        PasswordVerifier passwordVerifier = new PasswordVerifier();

        boolean result = passwordVerifier.verifierPassword(incorrectPassword, hashedPassword);

        Assertions.assertFalse(result);
    }

    // Teste para Verificação em caso de Hash incorreto.
    @org.junit.jupiter.api.Test
    void testVerifierIncorrectHash() {
        String password = "12345678";
        String incorrectHash = BCrypt.hashpw("IncorrectPassword", BCrypt.gensalt());


        PasswordVerifier passwordVerifier = new PasswordVerifier();

        boolean result = passwordVerifier.verifierPassword(password, incorrectHash);

        Assertions.assertFalse(result);
    }


}