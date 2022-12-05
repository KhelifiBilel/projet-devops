package com.project.education.controllers;

import com.project.education.entities.Student;
import com.project.education.exceptions.ResourceNotFoundException;
import com.project.education.services.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/students")
public class StudentController {
    @Autowired
    private IStudentService studentService;
    @GetMapping
    public List<Student> getAllStudents() {
        return this.studentService.getAll();
    }

    @GetMapping("/{id}")
    public Optional <Student> getStudentById(@PathVariable(value = "id") Integer id) {
        return this.studentService.getStudentById(id);
    }
    @PostMapping
    public Student addStudent(@RequestBody Student student ) throws ResourceNotFoundException {
        return this.studentService.addStudent(student,student.getDepartment().getIdDepartment());
    }

    @PutMapping
    public void updateStudent(@RequestBody Student student)
    {
        this.studentService.updateStudent(student);
    }
    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable(value="id") Integer id){
        this.studentService.deleteStudent(id);
    }

}
