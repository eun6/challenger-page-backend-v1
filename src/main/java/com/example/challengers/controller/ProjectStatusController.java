package com.example.challengers.controller;

import com.example.challengers.data.dto.UpdateProjectStatusDto;
import com.example.challengers.data.dto.ProjectStatusDto;
import com.example.challengers.data.dto.ProjectStatusResponseDto;
import com.example.challengers.service.ProjectStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@Controller
@RequestMapping("projectStatus")
public class ProjectStatusController {
    private final ProjectStatusService projectStatusService;
    @Autowired
    public ProjectStatusController(ProjectStatusService projectStatusService) {
        this.projectStatusService = projectStatusService;
    }

    @GetMapping("/get")
    public ResponseEntity<ProjectStatusResponseDto> getProjectStatus(Long id) {
        ProjectStatusResponseDto projectStatusResponseDto = projectStatusService.getProjectStatus(id);
        return ResponseEntity.status(HttpStatus.OK).body(projectStatusResponseDto);
    }

    @PostMapping("/post")
    public ResponseEntity<ProjectStatusResponseDto> createProjectStatus(@RequestBody ProjectStatusDto projectStatusDto) {
        ProjectStatusResponseDto projectStatusResponseDto = projectStatusService.saveProjectStatus(projectStatusDto);

        return ResponseEntity.status(HttpStatus.OK).body(projectStatusResponseDto);
    }

    @PutMapping("/put")
    public ResponseEntity<ProjectStatusResponseDto>updateProjectStatus(
            @RequestBody UpdateProjectStatusDto updateProjectStatusDto) throws Exception{
        ProjectStatusResponseDto productResponseDto = projectStatusService.updateProjectStatus(
                updateProjectStatusDto.getId(), updateProjectStatusDto.getStatus());

        return ResponseEntity.status(HttpStatus.OK).body(productResponseDto);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteProjectStatus(Long id) throws Exception {
        projectStatusService.deleteProjectStatus(id);

        return ResponseEntity.status(HttpStatus.OK).body("정상적으로 삭제되었습니다.");
    }
}
