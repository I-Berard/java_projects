package org.patient.school_management.services;

import org.patient.school_management.model.Course;
import org.patient.school_management.model.Teacher;
import org.patient.school_management.repository.CourseRepository;
import org.patient.school_management.repository.TeacherRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CourseService {

    private final CourseRepository courseRepository;
    private final TeacherRepository teacherRepository;

    public CourseService(CourseRepository courseRepository,
                         TeacherRepository teacherRepository) {
        this.courseRepository = courseRepository;
        this.teacherRepository = teacherRepository;
    }

    public Course create(org.patient.school_management.dto.CourseDTO dto) {
        Teacher teacher = null;
        if (dto.getTeacherId() != null) {
            teacher = teacherRepository.findById(dto.getTeacherId())
                    .orElseThrow(() -> new RuntimeException("Teacher not found"));
        }

        Course course = new Course();
        course.setCode(dto.getCode());
        course.setTitle(dto.getTitle());
        course.setDescription(dto.getDescription());
        course.setTeacher(teacher);

        return courseRepository.save(course);
    }

    public Course getById(UUID id) {
        return courseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Course not found"));
    }

    public List<Course> getAll() {
        return courseRepository.findAll();
    }

    public Course update(UUID id, org.patient.school_management.dto.CourseDTO updated) {

        Course existing = getById(id);

        existing.setCode(updated.getCode());
        existing.setTitle(updated.getTitle());
        existing.setDescription(updated.getDescription());

        if (updated.getTeacherId() != null) {
            Teacher teacher = teacherRepository.findById(updated.getTeacherId())
                    .orElseThrow(() -> new RuntimeException("Teacher not found"));
            existing.setTeacher(teacher);
        }

        return courseRepository.save(existing);
    }

    public void delete(UUID id) {
        courseRepository.deleteById(id);
    }

    public List<Course> getByTeacher(UUID teacherId) {
        return courseRepository.findByTeacherId(teacherId);
    }

    public Page<Course> getAllPaginated(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return courseRepository.findAll(pageable);
    }

    public List<Course> getByTeacherName(String name) {
        return courseRepository.findByTeacherName(name);
    }

    public List<Course> searchByCode(String keyword) {
        return courseRepository.searchByCode(keyword);
    }
}