package com.RestDemo.RestDemo.Controller;

import com.RestDemo.RestDemo.Entity.Student;
import com.RestDemo.RestDemo.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private StudentService studentService;
    @Autowired
    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        System.out.println("inside student service");
        Student s1 = studentService.createStudent(student);
        System.out.println("outside student service");
        return ResponseEntity.status(HttpStatus.CREATED).body(s1);
    }
    //Read
    //ReadAll
    //Update
    //Delete
}