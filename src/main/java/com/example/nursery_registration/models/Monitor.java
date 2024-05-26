package com.example.nursery_registration.models;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import java.util.Set;
import java.util.UUID;

@Data
@Entity
@Schema(description = "Monitor Entity")
public class Monitor {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(updatable = false, nullable = false)
    @Schema(description = "Unique identifier of the monitor", example = "123e4567-e89b-12d3-a456-426614174000")
    private UUID id;

    @Schema(description = "Name of the monitor", example = "Alice")
    private String name;

    @ManyToOne
    @JoinColumn(name = "classroom_id", nullable = false)
    @Schema(description = "Classroom associated with the monitor")
    private Classroom classroom;

    @ManyToMany(mappedBy = "monitors")
    @Schema(description = "List of students associated with the monitor")
    private Set<Student> students;
}
