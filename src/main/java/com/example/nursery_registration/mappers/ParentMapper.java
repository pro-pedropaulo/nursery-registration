package com.example.nursery_registration.mappers;

import com.example.nursery_registration.dtos.ParentDTO;
import com.example.nursery_registration.models.Parent;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ParentMapper {
    ParentDTO toParentDTO(Parent parent);
    Parent toParent(ParentDTO parentDTO);
}
