package com.example.relationteacher.Repository;

import com.example.relationteacher.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {
 Student findStudentById (Integer id);

}
