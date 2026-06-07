package org.patient.school_management.repository;

import org.patient.school_management.model.Role;
import org.patient.school_management.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {

    Optional<User> findByEmail(String email);

    boolean existsByEmail(String email);

    @Query("SELECT u from User u where u.role = ?1")
    List<User> findAdmins(Role role);

    List<User> findByRole(Role role);
}
