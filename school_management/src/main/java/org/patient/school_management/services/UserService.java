package org.patient.school_management.services;

import org.patient.school_management.dto.CreateUserDto;
import org.patient.school_management.model.Role;
import org.patient.school_management.model.User;
import org.patient.school_management.repository.UserRepository;
import org.springframework.stereotype.Service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository,
                           PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User register(CreateUserDto dto) {

        if (userRepository.existsByEmail(dto.email)) {
            throw new RuntimeException("Email already in use");
        }

        User user = new User();
        user.setPassword(passwordEncoder.encode(dto.password));

        if (dto.role == null) {
            user.setRole(Role.STUDENT);
        }else{
            user.setRole(dto.role);
        }

        return userRepository.save(user);
    }

    public User getById(UUID id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    public List<User> getAll() {
        return userRepository.findAll();
    }

    public User update(UUID id, User updatedUser) {

        User existing = getById(id);

        existing.setEmail(updatedUser.getEmail());

        if (updatedUser.getPassword() != null &&
                !updatedUser.getPassword().isEmpty()) {

            existing.setPassword(
                    passwordEncoder.encode(updatedUser.getPassword())
            );
        }

        existing.setRole(updatedUser.getRole());

        return userRepository.save(existing);
    }

    public void delete(UUID id) {
        userRepository.deleteById(id);
    }

    public User getByEmail(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }
}