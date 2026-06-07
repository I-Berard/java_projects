package org.patient.school_management.controller;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.patient.school_management.model.Student;
import org.patient.school_management.model.User;
import org.patient.school_management.repository.StudentRepository;
import org.patient.school_management.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import tools.jackson.databind.ObjectMapper;

import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class StudentControllerTest {

    private String authToken;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private StudentRepository studentRepository;

    @BeforeAll
    public void setupAuthToken() throws Exception{
        MvcResult result = mockMvc.perform(post("/api/auth/login")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
                        {
                            "email":"hello@gmail.com",
                            "password":"Berard"
                        }
                        """))
                .andReturn();
        String response = result.getResponse().getContentAsString();

        ObjectMapper mapper = new ObjectMapper();
        authToken = mapper.readTree(response).get("token").asText();
    }

    @Test
    void create() throws Exception {
        List<User> users = userRepository.findAll();
        UUID userId = users.getFirst().getId();

        mockMvc.perform(post("/api/students")
                .header("Authorization", "Bearer " + authToken)
                .content("""
                            {
                                "userId": "%s",
                                "fullName": "Irakoze Murasira Berard",
                                "admissionNumber": "7823"
                            }        
                        """.formatted(userId))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andExpect(jsonPath("$").exists());


    }

    @Test
    void getAll() throws Exception {
        mockMvc.perform(get("/api/students")
                .header("Authorization", "Bearer " + authToken))
                .andExpect(status().isOk()).andExpect(jsonPath("$").isArray());
    }

    @Test
    void getById() throws Exception {
        List<Student> students = studentRepository.findAll();
        UUID studentId = students.getFirst().getId();

        mockMvc.perform(get("/api/students/" + studentId)
                .header("Authorization", "Bearer " + authToken))
                .andExpect(status().isOk()).andExpect(jsonPath("$").exists());

    }

    @Test
    void update() {

    }

    @Test
    void delete() {
    }
}