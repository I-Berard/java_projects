package org.patient.school_management.controller;

import org.patient.school_management.dto.CourseDTO;
import org.patient.school_management.model.Course;
import org.patient.school_management.services.CourseService;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/courses")
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @PostMapping
    public Course create(@RequestBody CourseDTO dto) {
        return courseService.create(dto);
    }

    @GetMapping
    public List<Course> getAll() {
        return courseService.getAll();
    }

    @GetMapping("/{id}")
    public Course getById(@PathVariable UUID id) {
        return courseService.getById(id);
    }

    @PutMapping("/{id}")
    public Course update(@PathVariable UUID id,
                         @RequestBody CourseDTO dto) {
        return courseService.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        courseService.delete(id);
    }

    @GetMapping("/teacher/{teacherId}")
    public List<Course> getByTeacher(@PathVariable UUID teacherId) {
        return courseService.getByTeacher(teacherId);
    }

    @GetMapping("/paged")
    public Page<Course> getPagedCourses(
            @RequestParam int page,
            @RequestParam int size) {
        return courseService.getAllPaginated(page, size);
    }

    @GetMapping("/teacher")
    public List<Course> byTeacherName(@RequestParam String name) {
        return courseService.getByTeacherName(name);
    }

    @GetMapping("/search")
    public List<Course> search(@RequestParam String keyword) {
        return courseService.searchByCode(keyword);
    }
}