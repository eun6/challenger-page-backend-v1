package com.example.challengers.data.repository;

import com.example.challengers.data.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {

}
