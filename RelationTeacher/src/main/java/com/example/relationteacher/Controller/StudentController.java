package com.example.relationteacher.Controller;

import com.example.relationteacher.ApiResponse.ApiResponse;
import com.example.relationteacher.Model.Student;
import com.example.relationteacher.Service.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/v1/student")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;


    @GetMapping("/get")
    public ResponseEntity getAllStudents(){
        List<Student> studentList=studentService.getAllStudent();
        return ResponseEntity.status(200).body(studentList);
    }


    @PostMapping("/add")
    public ResponseEntity addStudent(@Valid @RequestBody Student student){
        studentService.addStudent(student);
        return ResponseEntity.status(200).body(new ApiResponse("Student added"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateStudent(@Valid @RequestBody Student student, @PathVariable Integer id){
        studentService.updateStudent(student, id);
        return ResponseEntity.status(200).body("Student Updated");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteStudent(@PathVariable Integer id){
        studentService.deleteStudent(id);
        return ResponseEntity.status(200).body("Student deleted");

    }

    @PutMapping("/{course_id}/assign/{student_id}")
    public ResponseEntity assignStudentToCourse(@PathVariable Integer course_id,@PathVariable Integer student_id) {
       studentService.assignStudentToCourse(student_id,course_id);
        return ResponseEntity.status(200).body("Assign Done");
    }

    @PutMapping("major/{id}/{major}")
    public ResponseEntity changeStudent(@PathVariable Integer student_id,@PathVariable String major){
        studentService.ChangeStudent(student_id, major);
        return ResponseEntity.status(200).body("Change Done");
    }

    @PutMapping("/get-student/{id}")
    public ResponseEntity studentlist(@PathVariable Integer  course_id){
        studentService.studentList(course_id);
        return ResponseEntity.status(200).body("Student List Done");
    }

}
