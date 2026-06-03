package org.patient.school_management.controller;

import org.patient.school_management.dto.EnrollmentDTO;
import org.patient.school_management.model.Enrollment;
import org.patient.school_management.services.EnrollmentService;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/enrollments")
public class EnrollmentController {

    private final EnrollmentService enrollmentService;

    public EnrollmentController(EnrollmentService enrollmentService) {
        this.enrollmentService = enrollmentService;
    }

    @PostMapping
    public Enrollment enroll(@RequestBody EnrollmentDTO dto) {
        return enrollmentService.enroll(dto.getStudentId(), dto.getCourseId());
    }

    @GetMapping
    public List<Enrollment> getAll() {
        return enrollmentService.getAll();
    }

    @GetMapping("/student/{studentId}")
    public List<Enrollment> getByStudent(@PathVariable UUID studentId) {
        return enrollmentService.getByStudent(studentId);
    }

    @GetMapping("/course/{courseId}")
    public List<Enrollment> getByCourse(@PathVariable UUID courseId) {
        return enrollmentService.getByCourse(courseId);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        enrollmentService.delete(id);
    }
}
