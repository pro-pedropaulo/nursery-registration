package com.example.nursery_registration.repositories;

import com.example.nursery_registration.models.Parent;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ParentRepository extends JpaRepository<Parent, UUID> {
}