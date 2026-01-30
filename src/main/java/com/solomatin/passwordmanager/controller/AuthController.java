package com.solomatin.passwordmanager.controller;

import com.solomatin.passwordmanager.dto.UserRegistrationDto;
import com.solomatin.passwordmanager.service.UserService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/auth")
public class AuthController {

    private static final Logger logger = LoggerFactory.getLogger(AuthController.class);

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute("user") UserRegistrationDto userDto) {
        try {
            userService.registerUser(userDto);
            logger.info("New user registered: {}", userDto.getEmail());
            return "redirect:/login?success";
        } catch (Exception e) {
            logger.error("Registration error: {}", e.getMessage());
            return "redirect:/register?error";
        }
    }

    @GetMapping("/status")
    public ResponseEntity<String> getStatus() {
        return ResponseEntity.ok("You are authenticated");
    }
}