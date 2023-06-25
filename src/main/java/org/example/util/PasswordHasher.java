package org.example.util;

import org.mindrot.jbcrypt.BCrypt;

public class PasswordHasher {
        public String hashPassword(String password) {
            String salt = BCrypt.gensalt();

            String hashedPassword = BCrypt.hashpw(password, salt);

            return hashedPassword;
        }
}
