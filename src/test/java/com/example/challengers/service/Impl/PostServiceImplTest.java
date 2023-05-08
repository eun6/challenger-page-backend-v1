package com.example.challengers.service.Impl;

import com.example.challengers.data.dto.PostDto;
import com.example.challengers.data.repository.ProjectStatusRepository;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.example.challengers.data.dao.PostDAO;
import com.example.challengers.data.domain.Post;
import com.example.challengers.data.domain.ProjectStatus;
import com.example.challengers.data.domain.Team;
import com.example.challengers.data.dto.PostResponseDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class PostServiceImplTest {
    @Mock
    private PostDAO postDAO;

    @InjectMocks
    private PostServiceImpl postService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @BeforeAll
    static void beforeAll(){
        System.out.println("Start Test");
    }

    @AfterAll
    static void afterAll(){
        System.out.println("End Test");
    }

    @Test
    void getPost() {
        Team team = new Team();
        team.setId(1L);
        team.setName("백엔드");

        ProjectStatus ps = new ProjectStatus();
        ps.setId(1L);
        ps.setStatus("공과공");

        Long postId = 1L;
        Post post = new Post();
        post.setId(postId);
        post.setProjectName("Test project name");
        post.setGithubPath("http://test.com/test");
        post.setContent("Test content");
        post.setImagePath("test/image.jpg");
        post.setTeam(team);
        post.setStatus(ps);
        when(postDAO.selectPost(postId)).thenReturn(post);

        PostResponseDto responseDto = postService.getPost(postId);
        Assertions.assertEquals(postId, responseDto.getId());
        Assertions.assertEquals(post.getProjectName(), responseDto.getProjectName());
        Assertions.assertEquals(post.getGithubPath(), responseDto.getGithubPath());
        Assertions.assertEquals(post.getContent(), responseDto.getContent());
        Assertions.assertEquals(post.getImagePath(), responseDto.getImagePath());
        Assertions.assertEquals(post.getTeam(), responseDto.getTeamId());
        Assertions.assertEquals(post.getStatus().getId(), responseDto.getStatusId());
        Assertions.assertEquals(post.getStatus().getStatus(), responseDto.getStatusValue());

        System.out.println("ID : " + responseDto.getId());
        System.out.println("ProjectName : " + responseDto.getProjectName());
        System.out.println("GithubPath : " + responseDto.getGithubPath());
        System.out.println("Content : " + responseDto.getContent());
        System.out.println("ImagePath : " + responseDto.getImagePath());
        System.out.println("TeamId : " + responseDto.getTeamId());
        System.out.println("StatusId : " + responseDto.getStatusId());
        System.out.println("StatusId : " + responseDto.getStatusValue());
        System.out.println("Test ok");
    }


    @Test
    void savePost() {
        Team team = new Team();
        team.setId(1L);
        team.setName("백엔드");

        ProjectStatus ps = new ProjectStatus();
        ps.setId(1L);
        ps.setStatus("공과공");

        PostDto postDto = new PostDto();
        postDto.setProjectName("Test project name");
        postDto.setGithubPath("http://test.com/test");
        postDto.setContent("Test content");
        postDto.setImagePath("test/image.jpg");
        postDto.setTeamId(team);
        postDto.setStatusId(ps.getId());

        System.out.println("test DTO: " + postDto.getProjectName());
        System.out.println("test setTeamId: " + postDto.getTeamId());

        Post post = new Post();
        post.setId(1L);
        post.setProjectName(postDto.getProjectName());
        post.setGithubPath(postDto.getGithubPath());
        post.setContent(postDto.getContent());
        post.setImagePath(postDto.getImagePath());
        post.setTeam(postDto.getTeamId());
        post.setStatus(ps);

        //이 부분 수정했음. post 객체 넘겼을 때도 되는지 다시 확인 필요. -> 확인.
        //다만, 이제 ID 넘겨받는 부분에서 new Team()한 주소 값이 넘겨지는 부분 해결 필요.
        when(postDAO.insertPost(any(Post.class))).thenReturn(post);

        PostResponseDto responseDto = postService.savePost(postDto);
        Assertions.assertEquals(post.getId(), responseDto.getId());
        Assertions.assertEquals(post.getProjectName(), responseDto.getProjectName());
        Assertions.assertEquals(post.getGithubPath(), responseDto.getGithubPath());
        Assertions.assertEquals(post.getContent(), responseDto.getContent());
        Assertions.assertEquals(post.getImagePath(), responseDto.getImagePath());
        Assertions.assertEquals(post.getTeam().getId(), responseDto.getTeamId());
        Assertions.assertEquals(post.getStatus().getId(), responseDto.getStatusId());
        Assertions.assertEquals(post.getStatus().getStatus(), responseDto.getStatusValue());
    }


    /*@Test
    void updatePost() {
    }

    @Test
    void deletePost() {
    }*/
}