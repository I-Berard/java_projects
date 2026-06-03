package org.patient.school_management.controller;

import org.patient.school_management.dto.StudentDTO;
import org.patient.school_management.model.Student;
import org.patient.school_management.services.StudentService;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public Student create(@RequestBody StudentDTO dto) {
        return studentService.create(dto);
    }

    @GetMapping
    public List<Student> getAll() {
        return studentService.getAll();
    }

    @GetMapping("/{id}")
    public Student getById(@PathVariable UUID id) {
        return studentService.getById(id);
    }

    @PutMapping("/{id}")
    public Student update(@PathVariable UUID id,
                          @RequestBody org.patient.school_management.dto.StudentDTO dto) {
        return studentService.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        studentService.delete(id);
    }
}