package com.RestDemo.RestDemo.Service;

import com.RestDemo.RestDemo.Entity.Student;
import com.RestDemo.RestDemo.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public List<Student> getAllStudents(){
        List<Student> ls=studentRepository.findAll();
        if(ls.isEmpty()) return null;
        return ls;
    }

    public Student getStudentById(Long id){
        Optional<Student> student=studentRepository.findById(id);
        if(!student.isPresent()){
            return null;
        }
        return student.get();
    }

    public Student updateStudentById(Long id, Student updatedStudent) {

        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        student.setName(updatedStudent.getName());
        student.setEmail(updatedStudent.getEmail());
        student.setAge(updatedStudent.getAge());
        student.setRollno(updatedStudent.getRollno());
        student.setSubject(updatedStudent.getSubject());


        return studentRepository.save(student);
    }
    public void deleteStudentById(Long id) {

        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        studentRepository.delete(student);
    }
}
