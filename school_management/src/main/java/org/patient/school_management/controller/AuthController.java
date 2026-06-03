package org.patient.school_management.controller;

import org.patient.school_management.dto.AuthResponse;
import org.patient.school_management.dto.LoginRequest;
import org.patient.school_management.dto.RegisterRequest;
import org.patient.school_management.model.Role;
import org.patient.school_management.model.User;
import org.patient.school_management.services.AuthService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public AuthResponse register(@RequestBody RegisterRequest request) {

        User user = new User();
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        user.setRole(Role.valueOf(request.getRole()));

        String token = authService.register(user);

        return new AuthResponse(token);
    }

    @PostMapping("/login")
    public AuthResponse login(@RequestBody LoginRequest request) {

        String token = authService.login(
                request.getEmail(),
                request.getPassword()
        );

        return new AuthResponse(token);
    }
}