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
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idStudent;
    private String lastName;
    private String firstName;
    @Enumerated(EnumType.STRING)
    private Field field;
    @ManyToOne
    @JoinColumn(referencedColumnName = "idDepartment")
    private Department department;
    @ManyToMany(mappedBy = "students")
    private Set<Team> teams;


}
