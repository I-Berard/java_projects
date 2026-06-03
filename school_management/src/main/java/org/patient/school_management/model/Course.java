package org.patient.school_management.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String code;

    private String title;

    private String description;

    @OneToMany(mappedBy = "course")
    private List<Enrollment> enrollments;

    @OneToOne
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;
}
