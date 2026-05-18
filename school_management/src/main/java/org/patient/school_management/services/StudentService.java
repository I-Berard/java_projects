package org.patient.school_management.services;

import org.patient.school_management.model.Course;
import org.patient.school_management.model.Student;
import org.patient.school_management.repository.StudentRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getAll(){
        return studentRepository.findAll();
    }

    public Student getByUsername(String username){
        return studentRepository.getStudentByName(username);
    }

    public Student getByEmail(String email){
        return studentRepository.getStudentByEmail(email);
    }

    public Optional<Student> Login(String identifier, String password){
        Student student = null;
        if(identifier.contains("@")){
            student = studentRepository.getStudentByEmail(identifier);
        }else{
            student = studentRepository.getStudentByName(identifier);
        }
        if(student != null && password.equals(student.getPassword())){
            student.setPassword(null);
            return Optional.of(student);
        }
        return Optional.empty();
    }

    public Student Register(String name, String email, String password, String className){
        Student student = new Student();
        student.setName(name); student.setEmail(email); student.setPassword(password); student.setClassName(className);
        return studentRepository.save(student);
    }

    public void AddCourses(UUID userId, List<Course> courses){
        Student student = studentRepository.getStudentById(userId);
        student.getCourses().addAll(courses);
        studentRepository.save(student);
    }

    public void setCourses(UUID userId, List<Course> courses){
        Student student = studentRepository.getStudentById(userId);
        student.setCourses(courses);
        studentRepository.save(student);
    }

    public Student getDetails(String email){
        Student student = studentRepository.getStudentByEmail(email);
        student.setPassword(null);
        return student;
    }

    public List<Student> getStudentsByCourseName(String courseName){
        return studentRepository.getStudentsByCourseName(courseName);
    }

    public Page<Student> getStudentsPageable(Pageable page){
        return  studentRepository.getStudentsPaginated(page);
    }

    public List<Student> getStudentsByClass(String className, String sortBy, String direction){
        Sort sort = direction.equalsIgnoreCase("asc") ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
        return studentRepository.findByClassName(className, sort);
    }
}
