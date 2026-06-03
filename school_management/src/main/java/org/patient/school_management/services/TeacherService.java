package org.patient.school_management.services;

import org.patient.school_management.dto.TeacherDTO;
import org.patient.school_management.model.Teacher;
import org.patient.school_management.model.User;
import org.patient.school_management.repository.TeacherRepository;
import org.patient.school_management.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TeacherService {

    private final TeacherRepository teacherRepository;
    private final UserRepository userRepository;

    public TeacherService(TeacherRepository teacherRepository,
                          UserRepository userRepository) {
        this.teacherRepository = teacherRepository;
        this.userRepository = userRepository;
    }

    public Teacher create(TeacherDTO dto) {
        User user = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        Teacher teacher = new Teacher();
        teacher.setUser(user);
        teacher.setFullName(dto.getFullName());
        teacher.setEmployeeNumber(dto.getEmployeeNumber());
        teacher.setDepartment(dto.getDepartment());

        return cleanTeacher(teacherRepository.save(teacher));
    }

    public Teacher getById(UUID id) {
        Teacher tch = teacherRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Teacher not found"));
        return cleanTeacher(tch);
    }

    public List<Teacher> getAll() {
        return cleanTeachers(teacherRepository.findAll());
    }

    public Teacher update(UUID id, TeacherDTO updated) {
        Teacher existing = getById(id);

        existing.setFullName(updated.getFullName());
        existing.setEmployeeNumber(updated.getEmployeeNumber());
        existing.setDepartment(updated.getDepartment());

        return cleanTeacher(teacherRepository.save(existing));
    }

    public void delete(UUID id) {
        teacherRepository.deleteById(id);
    }

    private Teacher cleanTeacher(Teacher teacher){
        teacher.getUser().setPassword(null);
        return teacher;
    }

    private List<Teacher> cleanTeachers(List<Teacher> teachers){
        teachers.forEach(this::cleanTeacher);
        return teachers;
    }
}
