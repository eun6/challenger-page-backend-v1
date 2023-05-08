package com.example.challengers.data.dto;

import com.example.challengers.data.domain.ProjectStatus;
import com.example.challengers.data.domain.Team;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PostResponseDto {
    private Long id;
    private String projectName;
    private String githubPath;
    private String content;
    private String imagePath;
    private Team teamId;
    private Long statusId;
    private String statusValue;
    public PostResponseDto(Long id, String projectName, String githubPath, String content, String imagePath,
                           Team teamId, Long statusId, String statusValue) {
        this.id = id;
        this.projectName = projectName;
        this.githubPath = githubPath;
        this.content = content;
        this.imagePath = imagePath;
        this.teamId = teamId;
        this.statusId = statusId;
        this.statusValue = statusValue;
    }
}
