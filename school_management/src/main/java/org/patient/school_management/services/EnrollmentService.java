package org.patient.school_management.services;

import org.patient.school_management.model.Course;
import org.patient.school_management.model.Enrollment;
import org.patient.school_management.model.Status;
import org.patient.school_management.model.Student;
import org.patient.school_management.repository.CourseRepository;
import org.patient.school_management.repository.EnrollmentRepository;
import org.patient.school_management.repository.StudentRepository;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class EnrollmentService {

    private final EnrollmentRepository enrollmentRepository;
    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;

    public EnrollmentService(EnrollmentRepository enrollmentRepository,
                             StudentRepository studentRepository,
                             CourseRepository courseRepository) {
        this.enrollmentRepository = enrollmentRepository;
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
    }

    public Enrollment enroll(UUID studentId, UUID courseId) {

        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new RuntimeException("Course not found"));

        Enrollment enrollment = new Enrollment();
        enrollment.setStudent(student);
        enrollment.setCourse(course);
        enrollment.setEnrolledAt(LocalDateTime.now());
        enrollment.setStatus(Status.ENROLLED);

        return enrollmentRepository.save(enrollment);
    }

    public List<Enrollment> getAll() {
        return enrollmentRepository.findAll();
    }

    public List<Enrollment> getByStudent(UUID studentId) {
        return enrollmentRepository.findByStudentId(studentId);
    }

    public List<Enrollment> getByCourse(UUID courseId) {
        return enrollmentRepository.findByCourseId(courseId);
    }

    public void delete(UUID id) {
        enrollmentRepository.deleteById(id);
    }
}