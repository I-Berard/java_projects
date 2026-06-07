package org.patient.school_management.controller;

import org.junit.jupiter.api.Test;
import org.patient.school_management.dto.EnrollmentDTO;
import org.patient.school_management.model.Enrollment;
import org.patient.school_management.services.EnrollmentService;
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

@WebMvcTest(controllers = EnrollmentController.class)
@AutoConfigureMockMvc(addFilters = false)
class EnrollmentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private JwtAuthFilter jwtAuthFilter;

    @MockitoBean
    private EnrollmentService enrollmentService;

    @Test
    void enroll() throws Exception {
        UUID studentId = UUID.randomUUID();
        UUID courseId = UUID.randomUUID();
        Enrollment enrollment = new Enrollment();
        enrollment.setId(UUID.randomUUID().toString());

        when(enrollmentService.enroll(eq(studentId), eq(courseId))).thenReturn(enrollment);

        mockMvc.perform(post("/api/enrollments")
                .contentType(MediaType.APPLICATION_JSON)
                .content(String.format("""
                        {
                            "studentId": "%s",
                            "courseId": "%s"
                        }
                        """, studentId, courseId)))
                .andExpect(status().isOk());
    }

    @Test
    void getAll() throws Exception {
        Enrollment enrollment = new Enrollment();
        enrollment.setId(UUID.randomUUID().toString());

        when(enrollmentService.getAll()).thenReturn(List.of(enrollment));

        mockMvc.perform(get("/api/enrollments"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray());
    }

    @Test
    void getByStudent() throws Exception {
        UUID studentId = UUID.randomUUID();
        Enrollment enrollment = new Enrollment();
        enrollment.setId(UUID.randomUUID().toString());

        when(enrollmentService.getByStudent(studentId)).thenReturn(List.of(enrollment));

        mockMvc.perform(get("/api/enrollments/student/" + studentId))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray());
    }

    @Test
    void getByCourse() throws Exception {
        UUID courseId = UUID.randomUUID();
        Enrollment enrollment = new Enrollment();
        enrollment.setId(UUID.randomUUID().toString());

        when(enrollmentService.getByCourse(courseId)).thenReturn(List.of(enrollment));

        mockMvc.perform(get("/api/enrollments/course/" + courseId))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray());
    }

    @Test
    void deleteEnrollment() throws Exception {
        UUID id = UUID.randomUUID();
        doNothing().when(enrollmentService).delete(id);

        mockMvc.perform(delete("/api/enrollments/" + id))
                .andExpect(status().isOk());
    }
}
