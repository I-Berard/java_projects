package org.patient.school_management.controller;

import org.junit.jupiter.api.Test;
import org.patient.school_management.dto.CreateUserDto;
import org.patient.school_management.model.Role;
import org.patient.school_management.model.User;
import org.patient.school_management.services.UserService;
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
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.patient.school_management.security.JwtAuthFilter;

@WebMvcTest(controllers = UserController.class)
@AutoConfigureMockMvc(addFilters = false)
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private JwtAuthFilter jwtAuthFilter;

    @MockitoBean
    private UserService userService;

    @Test
    void createUser() throws Exception {
        User user = new User();
        user.setId(UUID.randomUUID());
        user.setEmail("test@example.com");

        when(userService.register(any(CreateUserDto.class))).thenReturn(user);

        mockMvc.perform(post("/api/users")
                .contentType(MediaType.APPLICATION_JSON)
                .content("""
                        {
                            "email": "test@example.com",
                            "password": "password",
                            "role": "STUDENT"
                        }
                        """))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.email").value("test@example.com"));
    }

    @Test
    void getAllUsers() throws Exception {
        User user = new User();
        user.setId(UUID.randomUUID());
        user.setEmail("test@example.com");

        when(userService.getAll()).thenReturn(List.of(user));

        mockMvc.perform(get("/api/users"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray());
    }

    @Test
    void getUsersByRole() throws Exception {
        User user = new User();
        user.setId(UUID.randomUUID());
        user.setEmail("test@example.com");
        user.setRole(Role.STUDENT);

        when(userService.getByRole(Role.STUDENT)).thenReturn(List.of(user));

        mockMvc.perform(get("/api/users/role/STUDENT"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray());
    }

    @Test
    void updateUser() throws Exception {
        UUID id = UUID.randomUUID();
        User user = new User();
        user.setId(id);
        user.setEmail("updated@example.com");

        when(userService.update(eq(id), any(User.class))).thenReturn(user);

        mockMvc.perform(put("/api/users/" + id)
                .contentType(MediaType.APPLICATION_JSON)
                .content("""
                        {
                            "email": "updated@example.com",
                            "password": "newpassword",
                            "role": "STUDENT"
                        }
                        """))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.email").value("updated@example.com"));
    }

    @Test
    void updateRole() throws Exception {
        UUID id = UUID.randomUUID();
        User existingUser = new User();
        existingUser.setId(id);
        existingUser.setRole(Role.STUDENT);
        
        User updatedUser = new User();
        updatedUser.setId(id);
        updatedUser.setRole(Role.ADMIN);

        when(userService.getById(id)).thenReturn(existingUser);
        when(userService.update(eq(id), any(User.class))).thenReturn(updatedUser);

        mockMvc.perform(put("/api/users/" + id + "/role")
                .contentType(MediaType.APPLICATION_JSON)
                .content("""
                        {
                            "role": "ADMIN"
                        }
                        """))
                .andExpect(status().isOk());
    }
}
