package com.example.challengers.data.repository;

import com.example.challengers.data.domain.ProjectStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProjectStatusRepository extends JpaRepository<ProjectStatus, Long> {
    public ProjectStatus findByStatus(String status);
}
