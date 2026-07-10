package com.RestDemo.RestDemo.Repository;

import com.RestDemo.RestDemo.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    boolean existsByEmail(String email);

    List<Student> findByDeletedIsFalse();

    Optional<Object> findByIdAndDeletedIsFalse(Long id, boolean deleted);
}