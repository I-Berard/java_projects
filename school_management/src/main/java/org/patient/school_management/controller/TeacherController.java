package org.patient.school_management.controller;

import org.patient.school_management.dto.TeacherDTO;
import org.patient.school_management.model.Teacher;
import org.patient.school_management.services.TeacherService;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/teachers")
public class TeacherController {

    private final TeacherService teacherService;

    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @PostMapping
    public Teacher create(@RequestBody TeacherDTO dto) {
        return teacherService.create(dto);
    }

    @GetMapping
    public List<Teacher> getAll() {
        return teacherService.getAll();
    }

    @GetMapping("/{id}")
    public Teacher getById(@PathVariable UUID id) {
        return teacherService.getById(id);
    }

    @PutMapping("/{id}")
    public Teacher update(@PathVariable UUID id,
                          @RequestBody TeacherDTO dto) {
        return teacherService.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        teacherService.delete(id);
    }
}
