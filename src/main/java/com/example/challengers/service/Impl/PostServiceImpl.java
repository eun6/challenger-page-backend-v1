package com.example.challengers.service.Impl;

import com.example.challengers.data.dao.PostDAO;
import com.example.challengers.data.domain.Post;
import com.example.challengers.data.domain.ProjectStatus;
import com.example.challengers.data.domain.Team;
import com.example.challengers.data.dto.PostDto;
import com.example.challengers.data.dto.PostResponseDto;
import com.example.challengers.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class PostServiceImpl implements PostService {
    private final PostDAO postDAO;
    @Autowired
    public PostServiceImpl(PostDAO postDAO) {
        this.postDAO = postDAO;
    }

    //조회
    @Override
    @Transactional
    public PostResponseDto getPost(Long id) {
        Post post = postDAO.selectPost(id);

        PostResponseDto postResponseDto = new PostResponseDto();
        postResponseDto.setId(post.getId());

        return postResponseDto;
    }

    //저장
    @Override
    public PostResponseDto savePost(PostDto postDto) {
        Post post = new Post();
        post.setProjectName(postDto.getProjectName());
        post.setGithubPath(postDto.getGithubPath());
        post.setContent(postDto.getContent());
        post.setImagePath(postDto.getImagePath());
        post.setTeamId(postDto.getTeamId());
        post.setStatusId(postDto.getStatusId());


        Post savedProjectStatus = postDAO.insertPost(post);

        PostResponseDto postResponseDto = new PostResponseDto();
        postResponseDto.setId(savedProjectStatus.getId());
        postResponseDto.setProjectName(savedProjectStatus.getProjectName());
        postResponseDto.setGithubPath(savedProjectStatus.getGithubPath());
        postResponseDto.setContent(savedProjectStatus.getContent());
        postResponseDto.setImagePath(savedProjectStatus.getImagePath());
        postResponseDto.setTeamId(savedProjectStatus.getTeamId());
        postResponseDto.setStatusId(savedProjectStatus.getStatusId());

        return postResponseDto;
    }

    //업데이트
    @Override
    public PostResponseDto updatePost(Long id, String projectName, String githubPath,
                                      String content, String imagePath, Team teamId, ProjectStatus statusId) throws Exception {
        Post changedPost = postDAO.updatePost(id, projectName, githubPath, content, imagePath, teamId, statusId);

        PostResponseDto postResponseDto = new PostResponseDto();
        postResponseDto.setId(changedPost.getId());
        postResponseDto.setProjectName(changedPost.getProjectName());
        postResponseDto.setGithubPath(changedPost.getGithubPath());
        postResponseDto.setContent(changedPost.getContent());
        postResponseDto.setImagePath(changedPost.getImagePath());
        postResponseDto.setTeamId(changedPost.getTeamId());
        postResponseDto.setStatusId(changedPost.getStatusId());

        return postResponseDto;
    }

    @Override
    public void deletePost(Long id) throws Exception {
        postDAO.deletePost(id);
    }
}
