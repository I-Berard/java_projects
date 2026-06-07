package org.patient.school_management.controller;

import org.junit.jupiter.api.Test;
import org.patient.school_management.dto.TeacherDTO;
import org.patient.school_management.model.Teacher;
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

@WebMvcTest(controllers = TeacherController.class)
@AutoConfigureMockMvc(addFilters = false)
class TeacherControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private JwtAuthFilter jwtAuthFilter;

    @MockitoBean
    private TeacherService teacherService;

    @Test
    void create() throws Exception {
        Teacher teacher = new Teacher();
        teacher.setId(UUID.randomUUID());
        teacher.setFullName("John Doe");

        when(teacherService.create(any(TeacherDTO.class))).thenReturn(teacher);

        mockMvc.perform(post("/api/teachers")
                .contentType(MediaType.APPLICATION_JSON)
                .content("""
                        {
                            "userId": "123e4567-e89b-12d3-a456-426614174000",
                            "fullName": "John Doe",
                            "specialization": "Mathematics"
                        }
                        """))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.fullName").value("John Doe"));
    }

    @Test
    void getAll() throws Exception {
        Teacher teacher = new Teacher();
        teacher.setId(UUID.randomUUID());
        teacher.setFullName("John Doe");

        when(teacherService.getAll()).thenReturn(List.of(teacher));

        mockMvc.perform(get("/api/teachers"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray());
    }

    @Test
    void getById() throws Exception {
        UUID id = UUID.randomUUID();
        Teacher teacher = new Teacher();
        teacher.setId(id);
        teacher.setFullName("John Doe");

        when(teacherService.getById(id)).thenReturn(teacher);

        mockMvc.perform(get("/api/teachers/" + id))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.fullName").value("John Doe"));
    }

    @Test
    void update() throws Exception {
        UUID id = UUID.randomUUID();
        Teacher teacher = new Teacher();
        teacher.setId(id);
        teacher.setFullName("John Doe");

        when(teacherService.update(eq(id), any(TeacherDTO.class))).thenReturn(teacher);

        mockMvc.perform(put("/api/teachers/" + id)
                .contentType(MediaType.APPLICATION_JSON)
                .content("""
                        {
                            "userId": "123e4567-e89b-12d3-a456-426614174000",
                            "fullName": "John Doe",
                            "specialization": "Mathematics"
                        }
                        """))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.fullName").value("John Doe"));
    }

    @Test
    void deleteTeacher() throws Exception {
        UUID id = UUID.randomUUID();
        doNothing().when(teacherService).delete(id);

        mockMvc.perform(delete("/api/teachers/" + id))
                .andExpect(status().isOk());
    }
}
