package com.example.nursery_registration.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.UUID;

@Data
@Schema(description = "Classroom Data Transfer Object")
public class ClassroomDTO {

    @Schema(description = "Unique identifier of the classroom", example = "123e4567-e89b-12d3-a456-426614174000")
    private UUID id;

    @Schema(description = "Name of the classroom", example = "Room A")
    private String name;

    @Schema(description = "Capacity of the classroom", example = "30")
    private Integer capacity;
}
