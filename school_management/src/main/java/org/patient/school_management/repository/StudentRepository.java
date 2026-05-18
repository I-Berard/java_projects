package org.patient.school_management.repository;

import org.patient.school_management.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface StudentRepository extends JpaRepository<Student, UUID> {
    Student getStudentByName(String name);

    Student getStudentByEmail(String email);

    String id(UUID id);

    Student getStudentById(UUID uuid);

    @Query("SELECT s FROM Student s JOIN s.courses c WHERE c.name = ?1")
    List<Student> getStudentsByCourseName(String courseName);

    @Query(value = "SELECT * FROM spring_students ORDER BY id", countQuery = "SELECT COUNT(*) FROM spring_students", nativeQuery = true)
    Page<Student> getStudentsPaginated(Pageable page);

    List<Student> findByClassName(String name, Sort sort);
}
