package com.project.education.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Getter
@Setter
public class University {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idUniversity;
    private String universityName;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(referencedColumnName = "idUniversity")
    private Set<Department> departments;

}
