package org.patient.school_management.controller;

import org.patient.school_management.model.User;
import org.patient.school_management.repository.UserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping
    public List<User> getAllUsers() {
        List <User> users = userRepository.findAll();
        users.forEach(user -> user.setPassword(null));
        return users;
    }
}
