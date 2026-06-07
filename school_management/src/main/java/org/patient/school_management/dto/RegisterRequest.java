package org.patient.school_management.dto;

import lombok.Data;

@Data
public class RegisterRequest {
    private String email;
    private String password;
}
