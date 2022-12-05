package com.project.education.services;

import com.project.education.entities.Student;
import com.project.education.exceptions.ResourceNotFoundException;

import java.util.List;
import java.util.Optional;

public interface IStudentService {
    List<Student> getAll();
    Student  addStudent(Student student, Integer idDepartment) throws ResourceNotFoundException;
    void updateStudent(Student student);
    void deleteStudent(Integer id);
    Optional<Student> getStudentById(Integer id);
}
