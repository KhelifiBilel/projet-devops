package com.project.education.services;


import com.project.education.entities.Department;

import java.util.List;
import java.util.Optional;

public interface IDepartmentService {
    List<Department> getAll();

    void addDepartment(Department department);

    void updateDepartment(Department department);

    void deleteDepartment(Integer id);

    Optional<Department> getDepartmentById(Integer id);
}
