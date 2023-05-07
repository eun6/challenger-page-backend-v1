package com.example.challengers.data.dao;

import com.example.challengers.data.domain.ProjectStatus;

public interface ProjectStatusDAO {
    ProjectStatus insertProjectStatus(ProjectStatus projectStatus);
    ProjectStatus selectProjectStatus(Long id); // id 값으로 정보찾기
    ProjectStatus selectProjectStatus(String status); // status 값으로 정보찾기
    ProjectStatus updateProjectStatus(Long id, String status) throws Exception;
    void deleteProjectStatus(Long id) throws Exception;

}
