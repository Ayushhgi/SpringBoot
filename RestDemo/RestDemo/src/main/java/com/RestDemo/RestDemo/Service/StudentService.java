package com.RestDemo.RestDemo.Service;

import com.RestDemo.RestDemo.Entity.Student;
import com.RestDemo.RestDemo.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    StudentRepository studentRepository;

    @Autowired
    public void setStudentRepository(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student createStudent(Student student) {
        try {
            System.out.println("Before Save");

            Student s1 = studentRepository.save(student);

            System.out.println("After Save");
            System.out.println("Saved ID = " + s1.getId());

            return s1;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
}
