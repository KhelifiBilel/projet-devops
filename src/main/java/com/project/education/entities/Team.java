package com.project.education.entities;


import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer teamId;
    private String teamName;
    private Level level;
    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Student> students;
    @OneToOne(mappedBy = "team",cascade=CascadeType.ALL)
    private TeamDetails teamDetails;
}
