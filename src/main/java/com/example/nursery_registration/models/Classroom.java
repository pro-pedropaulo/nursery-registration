package com.example.nursery_registration.models;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import java.util.Set;
import java.util.UUID;

@Data
@Entity
@Schema(description = "Classroom Entity")
public class Classroom {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(updatable = false, nullable = false)
    @Schema(description = "Unique identifier of the classroom", example = "123e4567-e89b-12d3-a456-426614174000")
    private UUID id;

    @Schema(description = "Name of the classroom", example = "Room A")
    private String name;

    @Schema(description = "Capacity of the classroom", example = "30")
    private Integer capacity;

    @OneToMany(mappedBy = "classroom")
    @Schema(description = "List of students in the classroom")
    private Set<Student> students;

    @OneToMany(mappedBy = "classroom")
    @Schema(description = "List of monitors in the classroom")
    private Set<Monitor> monitors;
}
