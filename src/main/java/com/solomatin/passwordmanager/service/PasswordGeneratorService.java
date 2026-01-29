package com.solomatin.passwordmanager.service;

import org.springframework.stereotype.Service;
import java.security.SecureRandom;

@Service // Обов'язково додайте цю анотацію!
public class PasswordGeneratorService {
    private static final String CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*";

    public String generate(int length) {
        SecureRandom random = new SecureRandom();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append(CHARS.charAt(random.nextInt(CHARS.length())));
        }
        return sb.toString();
    }
}