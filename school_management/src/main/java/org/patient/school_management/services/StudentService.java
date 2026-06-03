package org.patient.school_management.services;

import org.patient.school_management.model.Student;
import org.patient.school_management.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class StudentService {

    private final StudentRepository studentRepository;
    private final org.patient.school_management.repository.UserRepository userRepository;

    public StudentService(StudentRepository studentRepository,
                          org.patient.school_management.repository.UserRepository userRepository) {
        this.studentRepository = studentRepository;
        this.userRepository = userRepository;
    }

    public Student create(org.patient.school_management.dto.StudentDTO dto) {
        org.patient.school_management.model.User user = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        Student student = new Student();
        student.setUser(user);
        student.setFullName(dto.getFullName());
        student.setAdmissionNumber(dto.getAdmissionNumber());

        return cleanStudent(studentRepository.save(student));
    }

    public Student getById(UUID id) {
        Student std = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));
        return cleanStudent(std);
    }

    public List<Student> getAll() {
        return cleanStudents(studentRepository.findAll());
    }

    public Student update(UUID id, org.patient.school_management.dto.StudentDTO updated) {
        Student existing = getById(id);

        existing.setFullName(updated.getFullName());
        existing.setAdmissionNumber(updated.getAdmissionNumber());

        return cleanStudent(studentRepository.save(existing));
    }

    public void delete(UUID id) {
        studentRepository.deleteById(id);
    }

    private Student cleanStudent(Student student){
        student.getUser().setPassword(null);
        return student;
    }

    private List<Student> cleanStudents(List<Student> students){
        students.forEach(this::cleanStudent);
        return students;
    }
}
