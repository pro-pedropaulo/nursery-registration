package com.example.nursery_registration.services;

import com.example.nursery_registration.dtos.ParentDTO;
import com.example.nursery_registration.models.Parent;
import com.example.nursery_registration.exceptions.ResourceNotFoundException;
import com.example.nursery_registration.mappers.ParentMapper;
import com.example.nursery_registration.repositories.ParentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ParentService {

    private final ParentRepository parentRepository;
    private final ParentMapper parentMapper;

    public ParentDTO createParent(ParentDTO parentDTO) {
        Parent parent = parentMapper.toParent(parentDTO);
        Parent savedParent = parentRepository.save(parent);
        return parentMapper.toParentDTO(savedParent);
    }

    public ParentDTO getParentById(UUID id) {
        Parent parent = parentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Parent not found"));
        return parentMapper.toParentDTO(parent);
    }

    public List<ParentDTO> getAllParents() {
        return parentRepository.findAll().stream().map(parentMapper::toParentDTO).collect(Collectors.toList());
    }

    public void deleteParent(UUID id) {
        if (!parentRepository.existsById(id)) {
            throw new ResourceNotFoundException("Parent not found");
        }
        parentRepository.deleteById(id);
    }
}
