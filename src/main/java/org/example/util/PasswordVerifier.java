package org.example.util;

import org.mindrot.jbcrypt.BCrypt;

public class PasswordVerifier {

    public boolean verifierPassword(String password, String hashedPassword) {
        return BCrypt.checkpw(password, hashedPassword);
    }

}
