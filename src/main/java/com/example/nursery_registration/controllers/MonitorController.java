package com.example.nursery_registration.controllers;

import com.example.nursery_registration.dtos.MonitorDTO;
import com.example.nursery_registration.services.MonitorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/monitors")
@RequiredArgsConstructor
@Tag(name = "Monitor Controller", description = "Endpoints for managing monitors")
public class MonitorController {

    private final MonitorService monitorService;

    @PostMapping
    @Operation(summary = "Create a new monitor")
    public ResponseEntity<MonitorDTO> createMonitor(@RequestBody MonitorDTO monitorDTO) {
        MonitorDTO createdMonitor = monitorService.createMonitor(monitorDTO);
        return new ResponseEntity<>(createdMonitor, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get a monitor by ID")
    public ResponseEntity<MonitorDTO> getMonitorById(@PathVariable UUID id) {
        MonitorDTO monitorDTO = monitorService.getMonitorById(id);
        return new ResponseEntity<>(monitorDTO, HttpStatus.OK);
    }

    @GetMapping
    @Operation(summary = "Get all monitors")
    public ResponseEntity<List<MonitorDTO>> getAllMonitors() {
        List<MonitorDTO> monitors = monitorService.getAllMonitors();
        return new ResponseEntity<>(monitors, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a monitor by ID")
    public ResponseEntity<Void> deleteMonitor(@PathVariable UUID id) {
        monitorService.deleteMonitor(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
