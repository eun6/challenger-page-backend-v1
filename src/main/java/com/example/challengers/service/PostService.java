package com.example.challengers.service;


import com.example.challengers.data.domain.ProjectStatus;
import com.example.challengers.data.domain.Team;
import com.example.challengers.data.dto.PostDto;
import com.example.challengers.data.dto.PostResponseDto;

public interface PostService {
    PostResponseDto getPost(Long id);
    PostResponseDto savePost(PostDto postDto);
    PostResponseDto updatePost(Long id, String projectName, String githubPath,
                               String content, String imagePath) throws Exception;
    void deletePost(Long id) throws Exception;
}
