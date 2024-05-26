package com.example.nursery_registration.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
public class ErrorResponse {
    private String message;
    private List<UUID> userIds;
}

