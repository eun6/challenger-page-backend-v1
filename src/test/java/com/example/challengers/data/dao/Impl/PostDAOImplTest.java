package com.example.challengers.data.dao.Impl;

import com.example.challengers.data.dao.PostDAO;
import com.example.challengers.data.domain.Post;

import com.example.challengers.data.domain.ProjectStatus;
import com.example.challengers.data.domain.Team;
import com.example.challengers.service.Impl.PostServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
class PostDAOImplTest {
    @Mock
    private PostDAO postDAO;

    @Test
    public void testInsertPost() {
        Team team = new Team();
        team.setId(1L);
        team.setName("백엔드");

        ProjectStatus ps = new ProjectStatus();
        ps.setId(1L);
        ps.setStatus("공과공");

        // given
        Post post = new Post();
        post.setProjectName("Test Project");
        post.setGithubPath("github.com/test/project");
        post.setContent("This is a test post");
        post.setImagePath("test.jpg");
        post.setTeam(team);
        post.setStatus(ps);

        // when
        Post savedPost = null;
        try {
            savedPost = postDAO.insertPost(post);
        } catch (RuntimeException e) {
            fail("Failed to insert post into database");
        }

        // then
        when(postDAO.insertPost(any(Post.class))).thenReturn(savedPost);
        assertNotNull(savedPost);
        assertNotNull(savedPost.getId());
        assertEquals(post.getProjectName(), savedPost.getProjectName());
        assertEquals(post.getGithubPath(), savedPost.getGithubPath());
        assertEquals(post.getContent(), savedPost.getContent());
        assertEquals(post.getImagePath(), savedPost.getImagePath());
        assertEquals(post.getTeam(), savedPost.getTeam());
        assertEquals(post.getStatus(), savedPost.getStatus());
    }

   /* @Test
    void selectPost() {
    }

    @Test
    void updatePost() {
    }

    @Test
    void deletePost() {
    }*/
}