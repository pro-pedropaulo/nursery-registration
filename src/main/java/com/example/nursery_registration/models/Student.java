package com.example.nursery_registration.models;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import com.example.nursery_registration.entities.Parent;

import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;

@Data
@Entity
@Schema(description = "Student Entity")
public class Student {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(updatable = false, nullable = false)
    @Schema(description = "Unique identifier of the student", example = "123e4567-e89b-12d3-a456-426614174000")
    private UUID id;

    @Schema(description = "Name of the student", example = "Jane Doe")
    private String name;

    @Schema(description = "Birth date of the student", example = "2010-05-15")
    private LocalDate birthDate;

    @ManyToOne
    @JoinColumn(name = "parent_id", nullable = false)
    @Schema(description = "Parent associated with the student")
    private Parent parent;

    @ManyToOne
    @JoinColumn(name = "classroom_id", nullable = false)
    @Schema(description = "Classroom associated with the student")
    private Classroom classroom;

    @ManyToMany
    @JoinTable(
            name = "student_monitor",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "monitor_id")
    )
    @Schema(description = "List of monitors associated with the student")
    private Set<Monitor> monitors;
}
