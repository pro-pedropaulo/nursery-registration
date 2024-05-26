package com.example.nursery_registration.entities;

import com.example.nursery_registration.models.Student;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import java.util.Set;
import java.util.UUID;

@Data
@Entity
@Schema(description = "Parent Entity")
public class Parent {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(updatable = false, nullable = false)
    @Schema(description = "Unique identifier of the parent", example = "123e4567-e89b-12d3-a456-426614174000")
    private UUID id;

    @Schema(description = "Name of the parent", example = "John Doe")
    private String name;

    @Schema(description = "Email of the parent", example = "john.doe@example.com")
    private String email;

    @Schema(description = "Phone number of the parent", example = "1234567890")
    private String phone;

    @OneToMany(mappedBy = "parent")
    @Schema(description = "List of students associated with the parent")
    private Set<Student> students;
}
