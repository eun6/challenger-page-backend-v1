package com.example.challengers.data.dao;

import com.example.challengers.data.domain.Post;
import com.example.challengers.data.domain.ProjectStatus;
import com.example.challengers.data.domain.Team;

public interface PostDAO {
    Post insertPost(Post post);
    Post selectPost(Long id); // id 값으로 정보찾기
    Post updatePost(Long id, String projectName, String githubPath,
                             String content, String imagePath, Team teamId, ProjectStatus statusId) throws Exception;
    void deletePost(Long id) throws Exception;

}