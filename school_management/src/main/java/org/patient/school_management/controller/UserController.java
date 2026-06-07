package org.patient.school_management.controller;

import org.patient.school_management.dto.CreateUserDto;
import org.patient.school_management.model.User;
import org.patient.school_management.services.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getAllUsers() {
        List<User> users = userService.getAll();
        users.forEach(user -> user.setPassword(null));
        return users;
    }

    @GetMapping("/role/{role}")
    public List<User> getUsersByRole(@PathVariable String role) {
        org.patient.school_management.model.Role roleEnum = org.patient.school_management.model.Role.valueOf(role.toUpperCase());
        List<User> users = userService.getByRole(roleEnum);
        users.forEach(user -> user.setPassword(null));
        return users;
    }

    @PostMapping
    public User createUser(@RequestBody CreateUserDto dto) {
        User user = userService.register(dto);
        user.setPassword(null);
        return user;
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable UUID id, @RequestBody User updatedUser) {
        User saved = userService.update(id, updatedUser);
        saved.setPassword(null);
        return saved;
    }

    @PutMapping("/{id}/role")
    public User updateRole(@PathVariable UUID id, @RequestBody User updatedUser) {
        User existing = userService.getById(id);
        existing.setRole(updatedUser.getRole());
        User saved = userService.update(id, existing);
        saved.setPassword(null);
        return saved;
    }
}
