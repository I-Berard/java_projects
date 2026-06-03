package org.patient.school_management.repository;

import org.patient.school_management.model.Course;
import org.patient.school_management.model.Teacher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface CourseRepository extends JpaRepository<Course, UUID> {
    List<Course> findByTeacherId(UUID teacherId);

    @Query("SELECT c from Course c where c.teacher.fullName = :name")
    List<Course> findByTeacherName(@Param("name") String name);

    Page<Course> findAll(Pageable pageable);

    @Query(value = "SELECT * FROM course WHERE code LIKE %:keyword%",
            nativeQuery = true)
    List<Course> searchByCode(@Param("keyword") String keyword);
}
