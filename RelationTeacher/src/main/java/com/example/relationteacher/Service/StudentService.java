package com.example.relationteacher.Service;

import com.example.relationteacher.ApiException.ApiException;
import com.example.relationteacher.Model.Course;
import com.example.relationteacher.Model.Student;
import com.example.relationteacher.Repository.CourseRepository;
import com.example.relationteacher.Repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;



    public List<Student> getAllStudent(){

        return studentRepository.findAll();
    }

    public void addStudent(Student student){
        studentRepository.save(student);
    }

    public void updateStudent(Student student,Integer id){
        Student oldStudent=studentRepository.findStudentById(id);

        if (oldStudent==null){
            throw new ArithmeticException("Student not Found");
        }
        oldStudent.setName(student.getName());
        oldStudent.setAge(student.getAge());
        oldStudent.setMajor(student.getMajor());

        studentRepository.save(oldStudent);
    }

    public void deleteStudent(Integer id){
        Student student=studentRepository.findStudentById(id);

        if (student==null){
            throw new ArithmeticException("Student not Found");
        }
        studentRepository.delete(student);

    }
    public void assignStudentToCourse(Integer student_id,Integer course_id){
        Student student=studentRepository.findStudentById(student_id);
        Course course=courseRepository.findCourseById(course_id);
        if(student==null || course==null){
            throw new ApiException("id wrong, can't assign Student to Course");
        }
        course.getStudents().add(student);
        student.getCourses().add(course);

        studentRepository.save(student);
        courseRepository.save(course);

    }
//Create endpoint that takes student id and major and change the student major
    public void ChangeStudent(Integer student_id, String major){
        Student student1=studentRepository.findStudentById(student_id);
        if (student1==null){
            throw new ApiException("Student Wrong");
        }
       student1.setMajor(major);
        student1.getCourses().clear();
        studentRepository.save(student1);

    }
//Create endpoint that takes class id and return the student list
    public Set<Student> studentList(Integer course_id){
        Course course=courseRepository.findCourseById(course_id);
        if (course==null){
            throw new ApiException("ID Wrong");
        }
        return course.getStudents();
    }

}
