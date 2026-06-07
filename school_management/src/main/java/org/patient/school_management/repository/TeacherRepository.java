package org.patient.school_management.repository;

import org.patient.school_management.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

import java.util.Optional;

public interface TeacherRepository extends JpaRepository<Teacher, UUID> {
    Optional<Teacher> findByUserId(UUID userId);
}
