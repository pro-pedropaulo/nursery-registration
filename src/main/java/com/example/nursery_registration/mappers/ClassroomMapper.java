package com.example.nursery_registration.mappers;

import com.example.nursery_registration.dtos.ClassroomDTO;
import com.example.nursery_registration.models.Classroom;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClassroomMapper {
    ClassroomDTO toClassroomDTO(Classroom classroom);
    Classroom toClassroom(ClassroomDTO classroomDTO);
}
