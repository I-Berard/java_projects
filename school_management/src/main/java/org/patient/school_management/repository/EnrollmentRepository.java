package org.patient.school_management.repository;

import org.patient.school_management.model.Course;
import org.patient.school_management.model.Enrollment;
import org.patient.school_management.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface EnrollmentRepository extends JpaRepository<Enrollment, UUID> {
    List<Enrollment> findByStudentId(UUID studentId);

    List<Enrollment> findByCourseId(UUID courseId);
}
