package com.example.nursery_registration.mappers;

import com.example.nursery_registration.dtos.MonitorDTO;
import com.example.nursery_registration.models.Monitor;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MonitorMapper {
    MonitorDTO toMonitorDTO(Monitor monitor);
    Monitor toMonitor(MonitorDTO monitorDTO);
}
