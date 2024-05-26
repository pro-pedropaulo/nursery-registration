package com.example.nursery_registration.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;

@Data
@Schema(description = "Student Data Transfer Object")
public class StudentDTO {

    @Schema(description = "Unique identifier of the student", example = "123e4567-e89b-12d3-a456-426614174000")
    private UUID id;

    @Schema(description = "Name of the student", example = "Jane Doe")
    private String name;

    @Schema(description = "Birth date of the student", example = "2010-05-15")
    private LocalDate birthDate;

    @Schema(description = "Unique identifier of the parent", example = "123e4567-e89b-12d3-a456-426614174000")
    private UUID parentId;

    @Schema(description = "Unique identifier of the classroom", example = "123e4567-e89b-12d3-a456-426614174000")
    private UUID classroomId;

    @Schema(description = "List of unique identifiers of the monitors", example = "[\"123e4567-e89b-12d3-a456-426614174000\"]")
    private Set<UUID> monitorIds;
}
