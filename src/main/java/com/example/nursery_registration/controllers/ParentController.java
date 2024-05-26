package com.example.nursery_registration.controllers;

import com.example.nursery_registration.dtos.ParentDTO;
import com.example.nursery_registration.services.ParentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/parents")
@RequiredArgsConstructor
@Tag(name = "Parent Controller", description = "Endpoints for managing parents")
public class ParentController {

    private final ParentService parentService;

    @PostMapping
    @Operation(summary = "Create a new parent")
    public ResponseEntity<ParentDTO> createParent(@RequestBody ParentDTO parentDTO) {
        ParentDTO createdParent = parentService.createParent(parentDTO);
        return new ResponseEntity<>(createdParent, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get a parent by ID")
    public ResponseEntity<ParentDTO> getParentById(@PathVariable UUID id) {
        ParentDTO parentDTO = parentService.getParentById(id);
        return new ResponseEntity<>(parentDTO, HttpStatus.OK);
    }

    @GetMapping
    @Operation(summary = "Get all parents")
    public ResponseEntity<List<ParentDTO>> getAllParents() {
        List<ParentDTO> parents = parentService.getAllParents();
        return new ResponseEntity<>(parents, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a parent by ID")
    public ResponseEntity<Void> deleteParent(@PathVariable UUID id) {
        parentService.deleteParent(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
