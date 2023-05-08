package com.example.challengers.data.dto;

import com.example.challengers.data.domain.ProjectStatus;
import com.example.challengers.data.domain.Team;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PostDto {
    private String projectName;
    private String githubPath;
    private String content;
    private String imagePath;
    private Team teamId;
    private Long statusId;
    public PostDto(String projectName, String githubPath, String content, String imagePath, Team teamId, Long statusId) {
        this.projectName = projectName;
        this.githubPath = githubPath;
        this.content = content;
        this.imagePath = imagePath;
        this.teamId = teamId;
        this.statusId = statusId;
    }
}
