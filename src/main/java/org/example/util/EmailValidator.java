package org.example.util;


import java.util.regex.Pattern;

public class EmailValidator {
    public static boolean emailValidator(String email) {
        String regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";

        Pattern pattern = Pattern.compile(regex);

        return pattern.matcher(email).matches();

    }
}
