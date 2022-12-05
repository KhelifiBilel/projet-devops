package com.project.education.services;

import com.project.education.entities.Department;
import com.project.education.entities.University;

import java.util.List;
import java.util.Optional;

public interface IUniversityService {
    List<University> getAll();
    void addUniversity(University university);
    void updateUniversity(University university);
    void deleteUniversity(Integer id);
    Optional<University> getUniversityById(Integer id);
}
