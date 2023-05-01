package com.example.challengers.data.domain;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name="team")
public class Team {
    //Id column
    @Id @GeneratedValue
    @Column(name = "team_id")
    private long id;

    //Other columns
    @Column(length = 45)
    @NotNull
    private String name;

//    //Slave
//    @OneToMany(mappedBy = "teamId", orphanRemoval = true)
//    List<Member> teamMember = new ArrayList<>(); //팀 맴버 조회
}
