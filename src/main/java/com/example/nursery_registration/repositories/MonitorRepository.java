package com.example.nursery_registration.repositories;

import com.example.nursery_registration.models.Monitor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MonitorRepository extends JpaRepository<Monitor, UUID> {
}