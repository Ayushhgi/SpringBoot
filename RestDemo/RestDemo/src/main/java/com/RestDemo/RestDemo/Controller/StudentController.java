package com.RestDemo.RestDemo.Controller;

import com.RestDemo.RestDemo.Entity.Student;
import com.RestDemo.RestDemo.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
        student.setDeleted(false);
        Student s1 = studentService.createStudent(student);
        System.out.println("outside student service");
        return ResponseEntity.status(HttpStatus.CREATED).body(s1);
    }
    //Read
    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Long id){
        Student student=studentService.getStudentById(id);

        if(student==null) return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(student);
    }
    //ReadAll
    @GetMapping
    public ResponseEntity<List<Student>> getStudent(){
        List<Student> ls=studentService.getAllStudents();

        if(ls.isEmpty()) return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(null);

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(ls);
    }
    //Update
    @PatchMapping("/{id}")
    public ResponseEntity<Student> updateStudentById(@PathVariable Long id , @RequestBody  Student s1){
        Student student =studentService.updateStudentById(id,s1);
        return ResponseEntity.ok(student);
    }
    //Delete
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudentById(@PathVariable Long id) {

        studentService.deleteStudentById(id);

        return ResponseEntity.ok("Student deleted successfully.");
    }
}