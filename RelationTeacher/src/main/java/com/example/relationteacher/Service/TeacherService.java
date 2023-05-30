package com.example.relationteacher.Service;

import com.example.relationteacher.Model.Address;
import com.example.relationteacher.Model.Teacher;
import com.example.relationteacher.Repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeacherService {
    private final TeacherRepository teacherRepository;

    public List<Teacher> getAllTeachers(){

        return teacherRepository.findAll();
    }

    public void addTeacher(Teacher teacher){
       teacherRepository.save(teacher);
    }

    public void updateTeacher(Teacher teacher,Integer id){
        Teacher oldTeacher=teacherRepository.findTeacherById(id);
        if (oldTeacher==null){
            throw new ArithmeticException("Teacher not Found");
        }
        oldTeacher.setName(teacher.getName());
        teacherRepository.save(oldTeacher);
    }

    public void deleteTeacher(Integer id){
        Teacher teacher=teacherRepository.findTeacherById(id);
        if (teacher==null){
            throw new ArithmeticException("Teacher not Found");
        }
        teacherRepository.delete(teacher);
    }

    public Address getAllTeacherById(Integer id){
        Teacher teacher=teacherRepository.findTeacherById(id);
            if (teacher==null) {
                throw new ArithmeticException("teacher id not found");
            }
            return teacher.getAddress();
        }


}
