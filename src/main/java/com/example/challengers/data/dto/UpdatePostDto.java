package com.example.challengers.data.dto;

import com.example.challengers.data.domain.ProjectStatus;
import com.example.challengers.data.domain.Team;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UpdatePostDto {
    private Long id;
    private String projectName;
    private String githubPath;
    private String content;
    private String imagePath;
    public UpdatePostDto(Long id, String projectName, String githubPath, String content, String imagePath) {
        this.id = id;
        this.projectName = projectName;
        this.githubPath = githubPath;
        this.content = content;
        this.imagePath = imagePath;
    }
}
