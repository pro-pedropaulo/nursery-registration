package com.example.nursery_registration.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.UUID;

@Data
@Schema(description = "Parent Data Transfer Object")
public class ParentDTO {

    @Schema(description = "Unique identifier of the parent", example = "123e4567-e89b-12d3-a456-426614174000")
    private UUID id;

    @Schema(description = "Name of the parent", example = "John Doe")
    private String name;

    @Schema(description = "Email of the parent", example = "john.doe@example.com")
    private String email;

    @Schema(description = "Phone number of the parent", example = "1234567890")
    private String phone;
}
