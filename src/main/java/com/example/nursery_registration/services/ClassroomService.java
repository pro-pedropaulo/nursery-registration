package com.example.nursery_registration.services;

import com.example.nursery_registration.dtos.ClassroomDTO;
import com.example.nursery_registration.models.Classroom;
import com.example.nursery_registration.exceptions.ResourceNotFoundException;
import com.example.nursery_registration.mappers.ClassroomMapper;
import com.example.nursery_registration.repositories.ClassroomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ClassroomService {

    private final ClassroomRepository classroomRepository;
    private final ClassroomMapper classroomMapper;

    public ClassroomDTO createClassroom(ClassroomDTO classroomDTO) {
        Classroom classroom = classroomMapper.toClassroom(classroomDTO);
        Classroom savedClassroom = classroomRepository.save(classroom);
        return classroomMapper.toClassroomDTO(savedClassroom);
    }

    public ClassroomDTO getClassroomById(UUID id) {
        Classroom classroom = classroomRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Classroom not found"));
        return classroomMapper.toClassroomDTO(classroom);
    }

    public List<ClassroomDTO> getAllClassrooms() {
        return classroomRepository.findAll().stream().map(classroomMapper::toClassroomDTO).collect(Collectors.toList());
    }

    public void deleteClassroom(UUID id) {
        if (!classroomRepository.existsById(id)) {
            throw new ResourceNotFoundException("Classroom not found");
        }
        classroomRepository.deleteById(id);
    }
}
