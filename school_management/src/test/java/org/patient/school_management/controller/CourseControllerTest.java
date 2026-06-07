package org.patient.school_management.controller;

import org.junit.jupiter.api.Test;
import org.patient.school_management.dto.CourseDTO;
import org.patient.school_management.model.Course;
import org.patient.school_management.services.CourseService;
import org.patient.school_management.services.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;
import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.patient.school_management.security.JwtAuthFilter;

@WebMvcTest(controllers = CourseController.class)
@AutoConfigureMockMvc(addFilters = false)
class CourseControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private JwtAuthFilter jwtAuthFilter;

    @MockitoBean
    private CourseService courseService;

    @MockitoBean
    private TeacherService teacherService;

    @Test
    void create() throws Exception {
        Course course = new Course();
        course.setId(UUID.randomUUID());
        course.setTitle("Math 101");

        when(courseService.create(any(CourseDTO.class))).thenReturn(course);

        mockMvc.perform(post("/api/courses")
                .contentType(MediaType.APPLICATION_JSON)
                .content("""
                        {
                            "title": "Math 101",
                            "code": "M101",
                            "teacherId": "123e4567-e89b-12d3-a456-426614174000"
                        }
                        """))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title").value("Math 101"));
    }

    @Test
    void getAll() throws Exception {
        Course course = new Course();
        course.setId(UUID.randomUUID());
        course.setTitle("Math 101");

        when(courseService.getAll()).thenReturn(List.of(course));

        mockMvc.perform(get("/api/courses"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].title").value("Math 101"));
    }

    @Test
    void getById() throws Exception {
        UUID id = UUID.randomUUID();
        Course course = new Course();
        course.setId(id);
        course.setTitle("Math 101");

        when(courseService.getById(id)).thenReturn(course);

        mockMvc.perform(get("/api/courses/" + id))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title").value("Math 101"));
    }

    @Test
    void update() throws Exception {
        UUID id = UUID.randomUUID();
        Course course = new Course();
        course.setId(id);
        course.setTitle("Updated Math");

        when(courseService.update(eq(id), any(CourseDTO.class))).thenReturn(course);

        mockMvc.perform(put("/api/courses/" + id)
                .contentType(MediaType.APPLICATION_JSON)
                .content("""
                        {
                            "title": "Updated Math",
                            "code": "M101"
                        }
                        """))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title").value("Updated Math"));
    }

    @Test
    void deleteCourse() throws Exception {
        UUID id = UUID.randomUUID();
        doNothing().when(courseService).delete(id);

        mockMvc.perform(delete("/api/courses/" + id))
                .andExpect(status().isOk());
    }
}
