package com.example.nursery_registration.services;

import com.example.nursery_registration.dtos.StudentDTO;
import com.example.nursery_registration.models.Student;
import com.example.nursery_registration.exceptions.ResourceNotFoundException;
import com.example.nursery_registration.mappers.StudentMapper;
import com.example.nursery_registration.repositories.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;

    public StudentDTO createStudent(StudentDTO studentDTO) {
        Student student = studentMapper.toStudent(studentDTO);
        Student savedStudent = studentRepository.save(student);
        return studentMapper.toStudentDTO(savedStudent);
    }

    public StudentDTO getStudentById(UUID id) {
        Student student = studentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Student not found"));
        return studentMapper.toStudentDTO(student);
    }

    public List<StudentDTO> getAllStudents() {
        return studentRepository.findAll().stream().map(studentMapper::toStudentDTO).collect(Collectors.toList());
    }

    public void deleteStudent(UUID id) {
        if (!studentRepository.existsById(id)) {
            throw new ResourceNotFoundException("Student not found");
        }
        studentRepository.deleteById(id);
    }
}
