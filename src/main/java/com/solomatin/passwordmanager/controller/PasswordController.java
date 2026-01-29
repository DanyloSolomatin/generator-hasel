package com.solomatin.passwordmanager.controller;

import com.solomatin.passwordmanager.service.PasswordGeneratorService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/passwords")
public class PasswordController {

    private final PasswordGeneratorService passwordService;

    // Впровадження сервісу (Dependency Injection)
    public PasswordController(PasswordGeneratorService passwordService) {
        this.passwordService = passwordService;
    }

    @GetMapping("/generate")
    public String generate(@RequestParam(defaultValue = "12") int length) {
        // Викликаємо бізнес-логіку з сервісу
        return passwordService.generate(length);
    }
}