package com.project.education.services;
import com.project.education.entities.Department;
import com.project.education.entities.Student;
import com.project.education.exceptions.ResourceNotFoundException;
import com.project.education.repositories.DepartmentRepository;
import com.project.education.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService implements IStudentService {
    @Autowired
    private DepartmentRepository departmentRepository;
    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<Student> getAll() {
        return this.studentRepository.findAll();
    }

    @Override
    public Student addStudent(Student student, Integer idDepartment) throws ResourceNotFoundException {
        Department department = this.departmentRepository.findById(idDepartment).orElseThrow(()-> new ResourceNotFoundException());

            student.setDepartment(department);

        return this.studentRepository.save(student);
    }

    @Override
    public void updateStudent(Student student) {
        this.studentRepository.save(student);
    }

    @Override
    public void deleteStudent(Integer id) {
        this.studentRepository.deleteById(id);
    }

    @Override
    public Optional<Student> getStudentById(Integer id) {
       return this.studentRepository.findById(id);
    }
}
