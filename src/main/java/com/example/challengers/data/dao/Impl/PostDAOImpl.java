package com.example.challengers.data.dao.Impl;

import com.example.challengers.data.dao.PostDAO;
import com.example.challengers.data.domain.Post;
import com.example.challengers.data.domain.ProjectStatus;
import com.example.challengers.data.domain.Team;
import com.example.challengers.data.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class PostDAOImpl implements PostDAO {

    private final PostRepository postRepository;

    @Autowired
    public PostDAOImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    // Post 엔티티를 DB에 저장
    @Override
    public Post insertPost(Post post) {
        Post savedPost = postRepository.save(post);
        return savedPost;
    }

    // *저장된 정보 선택
    // id 값으로 정보 찾기
    @Override
    public Post selectPost(Long id) {
        Post selectPost = postRepository.getById(id);
        return selectPost;
    }

    // Post 업데이트
    @Override
    public Post updatePost(Long id, String projectName, String githubPath,
                           String content, String imagePath, Team teamId, ProjectStatus statusId) throws Exception {
        Optional<Post> selectedPost = postRepository.findById(id);

        Post updatedPost;
        if(selectedPost.isPresent()) {
            Post post = selectedPost.get();

            post.setProjectName(projectName);
            post.setGithubPath(githubPath);
            post.setContent(content);
            post.setImagePath(imagePath);
            post.setTeamId(teamId);
            post.setStatusId(statusId);

            updatedPost = postRepository.save(post);
        } else {
            throw new Exception();
        }
        return updatedPost;
    }

    @Override
    public void deletePost(Long id) throws Exception {
        Optional<Post> selectedPost = postRepository.findById(id);

        if(selectedPost.isPresent()) {
            Post post = selectedPost.get();

            postRepository.delete(post);
        } else {
            throw new Exception();
        }
    }
}