package com.example.challengers.data.repository;

import com.example.challengers.data.domain.ProjectStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectStatusRepository extends JpaRepository<ProjectStatus, Long> {
}
