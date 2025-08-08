package com.ku.spring.college.college.controller;

import java.util.List;

import com.ku.spring.college.college.dto.StudentRequestDto;
import com.ku.spring.college.college.dto.StudentResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ku.spring.college.college.models.Course;
import com.ku.spring.college.college.models.Student;
import com.ku.spring.college.college.service.StudentService;

@RestController
@RequestMapping("/api/v1/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public ResponseEntity<List<StudentResponseDto>> getAllStudents(){
        List<StudentResponseDto> students = studentService.getAllStudents();
        return ResponseEntity.status(HttpStatus.OK).body(students);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentResponseDto> getStudentById(@PathVariable Long id){
        StudentResponseDto student = studentService.getStudentById(id);
        return ResponseEntity.status(HttpStatus.OK).body(student);
    }

    @PostMapping
    public ResponseEntity<StudentResponseDto> createStudent(@RequestBody StudentRequestDto studentRequestDto){
        StudentResponseDto student = studentService.createStudent(studentRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(student);
    }

    // Uso PUT porque modifico la relacion de cursos de un estudiante existente
    @PutMapping("/{id}/courses")
    public ResponseEntity<Student> addCourseToStudent(@PathVariable Long id, @RequestBody List<Course> courses){
        Student updatedStudent = studentService.addCoursesToStudent(id, courses);
        return ResponseEntity.status(HttpStatus.OK).body(updatedStudent);
    }


    @PutMapping("/{id}")
    public ResponseEntity<StudentResponseDto> updateStudent(@PathVariable Long id, @RequestBody StudentRequestDto studentDetails){
        StudentResponseDto updateStudent = studentService.updateStudent(id, studentDetails);
        return ResponseEntity.status(HttpStatus.OK).body(updateStudent);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long id){
        studentService.deleteStudent(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }



}
