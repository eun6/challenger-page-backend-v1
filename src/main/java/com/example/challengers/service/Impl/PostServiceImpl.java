package com.example.challengers.service.Impl;

import com.example.challengers.data.dao.PostDAO;
import com.example.challengers.data.domain.Post;
import com.example.challengers.data.domain.ProjectStatus;
import com.example.challengers.data.domain.Team;
import com.example.challengers.data.dto.PostDto;
import com.example.challengers.data.dto.PostResponseDto;
import com.example.challengers.data.repository.ProjectStatusRepository;
import com.example.challengers.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class PostServiceImpl implements PostService {
    private final PostDAO postDAO;
    private final ProjectStatusRepository projectStatusRepository;

    @Autowired
    public PostServiceImpl(PostDAO postDAO, ProjectStatusRepository projectStatusRepository) {
        this.postDAO = postDAO;
        this.projectStatusRepository = projectStatusRepository;
    }

    //조회
    @Override
    @Transactional
    public PostResponseDto getPost(Long id) {
        Post post = postDAO.selectPost(id);

        PostResponseDto postResponseDto = new PostResponseDto();
        postResponseDto.setId(post.getId());

        postResponseDto.setProjectName(post.getProjectName());
        postResponseDto.setGithubPath(post.getGithubPath());
        postResponseDto.setContent(post.getContent());
        postResponseDto.setImagePath(post.getImagePath());
        postResponseDto.setTeamId(post.getTeam());
        postResponseDto.setStatusId(post.getStatusValue().getId());
        postResponseDto.setStatusValue(post.getStatusValue().getStatus());

        return postResponseDto;
    }

    //저장
    @Override
    public PostResponseDto savePost(PostDto postDto) {
        System.out.println("postDto.getStatusId(): " + postDto.getStatusId());
        //System.out.println("statusID : " + projectStatusRepository.getById(postDto.getStatusId()));

        ProjectStatus statusID = projectStatusRepository.getById(postDto.getStatusId());
        //System.out.println("statusID : " + statusID);

        Post post = new Post();
        post.setProjectName(postDto.getProjectName());
        post.setGithubPath(postDto.getGithubPath());
        post.setContent(postDto.getContent());
        post.setImagePath(postDto.getImagePath());
        post.setTeam(postDto.getTeamId());
        post.setStatusValue(statusID);

        Post savedPostStatus = postDAO.insertPost(post);
        System.out.println("savedPostStatus : " + savedPostStatus.getProjectName());
        System.out.println("getTeamId : " + savedPostStatus.getTeam().getId());
        System.out.println("getStatusId : " + savedPostStatus.getStatusValue().getId());
        System.out.println("getStatus : " + savedPostStatus.getStatusValue().getStatus());

        PostResponseDto postResponseDto = new PostResponseDto();
        postResponseDto.setId(savedPostStatus.getId());
        postResponseDto.setProjectName(savedPostStatus.getProjectName());
        postResponseDto.setGithubPath(savedPostStatus.getGithubPath());
        postResponseDto.setContent(savedPostStatus.getContent());
        postResponseDto.setImagePath(savedPostStatus.getImagePath());
        postResponseDto.setTeamId(savedPostStatus.getTeam());
        postResponseDto.setStatusId(savedPostStatus.getStatusValue().getId());
        postResponseDto.setStatusValue(savedPostStatus.getStatusValue().getStatus());

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
        postResponseDto.setTeamId(changedPost.getTeam());
        postResponseDto.setStatusId(changedPost.getStatusValue().getId());

        return postResponseDto;
    }

    @Override
    public void deletePost(Long id) throws Exception {
        postDAO.deletePost(id);
    }
}
