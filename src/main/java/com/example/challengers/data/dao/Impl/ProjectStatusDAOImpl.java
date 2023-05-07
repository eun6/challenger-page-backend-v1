package com.example.challengers.data.dao.Impl;

import com.example.challengers.data.dao.ProjectStatusDAO;
import com.example.challengers.data.domain.ProjectStatus;
import com.example.challengers.data.repository.ProjectStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ProjectStatusDAOImpl implements ProjectStatusDAO {

    private final ProjectStatusRepository projectStatusRepository;

    @Autowired
    public ProjectStatusDAOImpl(ProjectStatusRepository projectStatusRepository) {
        this.projectStatusRepository = projectStatusRepository;
    }

    // ProjectStatus 엔티티를 DB에 저장
    @Override
    public ProjectStatus insertProjectStatus(ProjectStatus projectStatus) {
        ProjectStatus savedProjectStatus = projectStatusRepository.save(projectStatus);
        return savedProjectStatus;
    }

    // *저장된 정보 선택
    // id 값으로 정보 찾기
    @Override
    public ProjectStatus selectProjectStatus(Long id) {
        ProjectStatus selectProjectStatus = projectStatusRepository.getById(id);
        return selectProjectStatus;
    }

    // status 값으로 정보 찾기.
    @Override
    public ProjectStatus selectProjectStatus(String status) {
        ProjectStatus selectProjectStatus = projectStatusRepository.findByStatus(status);
        return selectProjectStatus;
    }

    // ProjectStatus 업데이트
    @Override
    public ProjectStatus updateProjectStatus(Long id, String status) throws Exception {
        Optional<ProjectStatus> selectedProjectStatus = projectStatusRepository.findById(id);

        ProjectStatus updatedProjectStauts;
        if(selectedProjectStatus.isPresent()) {
            ProjectStatus projectStatus = selectedProjectStatus.get();

            projectStatus.setStatus(status);

            updatedProjectStauts = projectStatusRepository.save(projectStatus);
        } else {
            throw new Exception();
        }
        return updatedProjectStauts;
    }

    @Override
    public void deleteProjectStatus(Long id) throws Exception {
        Optional<ProjectStatus> selectedProjectStatus = projectStatusRepository.findById(id);

        if(selectedProjectStatus.isPresent()) {
            ProjectStatus project = selectedProjectStatus.get();

            projectStatusRepository.delete(project);
        } else {
            throw new Exception();
        }
    }
}
