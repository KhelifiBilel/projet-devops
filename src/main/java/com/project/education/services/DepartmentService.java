package com.project.education.services;

import com.project.education.entities.Department;
import com.project.education.repositories.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService implements IDepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public List<Department> getAll() {
        return this.departmentRepository.findAll();
    }

    @Override
    public void addDepartment(Department department) {
        this.departmentRepository.save(department);

    }

    @Override
    public void updateDepartment(Department department) {
        this.departmentRepository.save(department);
    }

    @Override
    public void deleteDepartment(Integer id) {
        this.departmentRepository.deleteById(id);
    }

    @Override
    public Optional<Department> getDepartmentById(Integer id) {
        return this.departmentRepository.findById(id);

    }
}
