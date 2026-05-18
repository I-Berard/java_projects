package org.patient.school_management.controller;

import org.patient.school_management.model.Course;
import org.patient.school_management.model.Student;
import org.patient.school_management.services.StudentService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    // 🔹 Get all students
    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getAll();
    }

    // 🔹 Get by username
    @GetMapping("/username/{username}")
    public Student getByUsername(@PathVariable String username) {
        return studentService.getByUsername(username);
    }

    // 🔹 Get by email
    @GetMapping("/email/{email}")
    public Student getByEmail(@PathVariable String email) {
        return studentService.getByEmail(email);
    }

    // 🔹 Login
    @PostMapping("/login")
    public Optional<Student> login(@RequestParam String identifier,
                                   @RequestParam String password) {
        return studentService.Login(identifier, password);
    }

    // 🔹 Register
    @PostMapping("/register")
    public Student register(@RequestParam String name,
                            @RequestParam String email,
                            @RequestParam String password, @RequestParam String className) {
        return studentService.Register(name, email, password, className);
    }

    // 🔹 Add courses (append)
    @PostMapping("/{userId}/courses/add")
    public void addCourses(@PathVariable UUID userId,
                           @RequestBody List<Course> courses) {
        studentService.AddCourses(userId, courses);
    }

    // 🔹 Set courses (replace)
    @PutMapping("/{userId}/courses")
    public void setCourses(@PathVariable UUID userId,
                           @RequestBody List<Course> courses) {
        studentService.setCourses(userId, courses);
    }

    // 🔹 Get student details (without password)
    @GetMapping("/details/{email}")
    public Student getDetails(@PathVariable String email) {
        return studentService.getDetails(email);
    }

    @GetMapping("/courses/{name}")
    public List<Student> getStudentsByCourseName(@PathVariable String courseName){
        return studentService.getStudentsByCourseName(courseName);
    }

    @GetMapping("/page/student")
    public Page<Student> getStudentsPaginated(Pageable page){
        return studentService.getStudentsPageable(page);
    }

    @GetMapping("/class/{className}")
    public List<Student> findByClassName(@RequestParam String className, @RequestParam(defaultValue = "name") String sortBy, @RequestParam(defaultValue = "desc") String direction){
        return studentService.getStudentsByClass(className, sortBy, direction);
    }

}