package com.example.challengers.service;

import com.example.challengers.data.dto.ProjectStatusDto;
import com.example.challengers.data.dto.ProjectStatusResponseDto;

public interface ProjectStatusService {
    ProjectStatusResponseDto getProjectStatus(Long id);
    ProjectStatusResponseDto saveProjectStatus(ProjectStatusDto projectStatusDto);
    ProjectStatusResponseDto updateProjectStatus(Long id, String status) throws Exception;
    void deleteProjectStatus(Long id) throws Exception;
}
