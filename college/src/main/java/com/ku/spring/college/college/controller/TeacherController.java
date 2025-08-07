package com.ku.spring.college.college.controller;

import java.util.List;

import com.ku.spring.college.college.dto.TeacherRequestDto;
import com.ku.spring.college.college.dto.TeacherResponseDto;
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
import com.ku.spring.college.college.models.Teacher;
import com.ku.spring.college.college.service.TeacherService;

@RestController
@RequestMapping("/api/v1/teachers")
public class TeacherController {

    private final TeacherService teacherService;

    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @GetMapping
    public ResponseEntity<List<TeacherResponseDto>> getAllTeachers() {
        List<TeacherResponseDto> teachers = teacherService.getAllTeachers();
        return ResponseEntity.status(HttpStatus.OK).body(teachers);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TeacherResponseDto> getTecherById(@PathVariable Long id) {
        TeacherResponseDto teacher = teacherService.getTeacherById(id);
        return ResponseEntity.status(HttpStatus.OK).body(teacher);
    }

    @PostMapping
    public ResponseEntity<TeacherResponseDto> createTeacher(@RequestBody TeacherRequestDto teacherDto) {
        TeacherResponseDto newTeacher = teacherService.createTeacher(teacherDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(newTeacher);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TeacherResponseDto> updateTeacher(@PathVariable Long id, @RequestBody TeacherRequestDto teacherDetails) {
        TeacherResponseDto updatedTeacher = teacherService.updateTeacher(id, teacherDetails);
        return ResponseEntity.status(HttpStatus.OK).body(updatedTeacher);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTeacher(@PathVariable Long id) {
        teacherService.deleteTeacher(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping("/{id}/courses")
    public ResponseEntity<Teacher> addCoursesToTeacher(
            @PathVariable Long id,
            @RequestBody List<Course> courses) {
        Teacher updatedTeacher = teacherService.addTeacherToCourse(id, courses);
        return ResponseEntity.ok(updatedTeacher);
    }

}
