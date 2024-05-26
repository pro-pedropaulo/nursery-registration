package com.example.nursery_registration.services;

import com.example.nursery_registration.dtos.MonitorDTO;
import com.example.nursery_registration.models.Monitor;
import com.example.nursery_registration.exceptions.ResourceNotFoundException;
import com.example.nursery_registration.mappers.MonitorMapper;
import com.example.nursery_registration.repositories.MonitorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MonitorService {

    private final MonitorRepository monitorRepository;
    private final MonitorMapper monitorMapper;

    public MonitorDTO createMonitor(MonitorDTO monitorDTO) {
        Monitor monitor = monitorMapper.toMonitor(monitorDTO);
        Monitor savedMonitor = monitorRepository.save(monitor);
        return monitorMapper.toMonitorDTO(savedMonitor);
    }

    public MonitorDTO getMonitorById(UUID id) {
        Monitor monitor = monitorRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Monitor not found"));
        return monitorMapper.toMonitorDTO(monitor);
    }

    public List<MonitorDTO> getAllMonitors() {
        return monitorRepository.findAll().stream().map(monitorMapper::toMonitorDTO).collect(Collectors.toList());
    }

    public void deleteMonitor(UUID id) {
        if (!monitorRepository.existsById(id)) {
            throw new ResourceNotFoundException("Monitor not found");
        }
        monitorRepository.deleteById(id);
    }
}
