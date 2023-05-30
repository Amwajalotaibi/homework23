package com.example.relationteacher.Service;


import com.example.relationteacher.ApiException.ApiException;
import com.example.relationteacher.Model.Course;
import com.example.relationteacher.Model.Teacher;
import com.example.relationteacher.Repository.CourseRepository;
import com.example.relationteacher.Repository.TeacherRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class CourseService {
    private final CourseRepository courseRepository;
    private final TeacherRepository teacherRepository;


    public List<Course> getAllCourse(){

        return courseRepository.findAll();
    }

    public void addCourse(Course course){
        courseRepository.save(course);

    }

    public void updateCourse(Course course,Integer id){
        Course oldCourse=courseRepository.findCourseById(id);

        if (oldCourse==null){
            throw new ArithmeticException("Course not Found");
        }
        oldCourse.setName(course.getName());
//        oldCourse.setTeacher(course.getTeacher());
       courseRepository.save(oldCourse);
    }

    public void deleteCourse(Integer id){
        Course course=courseRepository.findCourseById(id);

        if (course==null){
            throw new ArithmeticException("Course not Found");
        }
        courseRepository.delete(course);
    }
    public void assignTeacherToCourse(Integer teacher_id,Integer course_id){
        Teacher teacher=teacherRepository.findTeacherById(teacher_id);
        Course course=courseRepository.findCourseById(course_id);
        if(teacher==null || course==null){
            throw new ApiException("id wrong, can't assign Teacher to Course");
        }
        course.setTeacher(teacher);
        courseRepository.save(course);

    }

}
