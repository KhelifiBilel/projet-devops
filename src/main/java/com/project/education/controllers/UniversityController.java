package com.project.education.controllers;

import com.project.education.entities.University;
import com.project.education.services.IUniversityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/universities")
public class UniversityController {
    @Autowired
    private IUniversityService universityService;
    @PostMapping
    public void addUniversity(@RequestBody University university)
    {
        this.universityService.addUniversity(university);
    }

    @GetMapping
    public List<University> getAllUniversities(){
        return this.universityService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<University> getUniversityById(@PathVariable(value="id") Integer id){
        return this.universityService.getUniversityById(id);
    }
}
