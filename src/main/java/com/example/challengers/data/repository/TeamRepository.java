package com.example.challengers.data.repository;

import com.example.challengers.data.domain.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TeamRepository extends JpaRepository<Team, Long> {
}