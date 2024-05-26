package com.example.nursery_registration.controllers;

import com.example.nursery_registration.dtos.ClassroomDTO;
import com.example.nursery_registration.services.ClassroomService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/classrooms")
@RequiredArgsConstructor
@Tag(name = "Classroom Controller", description = "Endpoints for managing classrooms")
public class ClassroomController {

    private final ClassroomService classroomService;

    @PostMapping
    @Operation(summary = "Create a new classroom")
    public ResponseEntity<ClassroomDTO> createClassroom(@RequestBody ClassroomDTO classroomDTO) {
        ClassroomDTO createdClassroom = classroomService.createClassroom(classroomDTO);
        return new ResponseEntity<>(createdClassroom, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get a classroom by ID")
    public ResponseEntity<ClassroomDTO> getClassroomById(@PathVariable UUID id) {
        ClassroomDTO classroomDTO = classroomService.getClassroomById(id);
        return new ResponseEntity<>(classroomDTO, HttpStatus.OK);
    }

    @GetMapping
    @Operation(summary = "Get all classrooms")
    public ResponseEntity<List<ClassroomDTO>> getAllClassrooms() {
        List<ClassroomDTO> classrooms = classroomService.getAllClassrooms();
        return new ResponseEntity<>(classrooms, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a classroom by ID")
    public ResponseEntity<Void> deleteClassroom(@PathVariable UUID id) {
        classroomService.deleteClassroom(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
