package com.project.education.controllers;

import com.project.education.entities.Department;
import com.project.education.services.IDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(("/api/departments"))
public class DepartmentController {
    @Autowired
    private IDepartmentService departmentService;
    @GetMapping
    public List<Department> getAllDepartments() {
        return this.departmentService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Department> getDepartmentById(@PathVariable(value ="id") Integer id) {
        return this.departmentService.getDepartmentById(id);
    }
    @PostMapping
    public void addDepartment(@RequestBody Department department) {
        this.departmentService.addDepartment(department);
    }

    @PutMapping
    public void updateDepartment(@RequestBody Department department)
    {
        this.departmentService.updateDepartment(department);
    }
    @DeleteMapping("/{id}")
    public void deleteDepartment(@PathVariable(value="id") Integer id){
        this.departmentService.deleteDepartment(id);
    }
    
}
