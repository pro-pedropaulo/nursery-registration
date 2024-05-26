package com.example.nursery_registration.mappers;

import com.example.nursery_registration.dtos.StudentDTO;
import com.example.nursery_registration.models.Student;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StudentMapper {
    StudentDTO toStudentDTO(Student student);
    Student toStudent(StudentDTO studentDTO);
}
