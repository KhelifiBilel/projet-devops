package com.project.education.entities;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class TeamDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idTeamDetails;
    private String theme;
    private String room;
    @OneToOne
    @JoinColumn(referencedColumnName = "teamId")
    private Team team;
}
