package com.ku.spring.college.college.controller;

import java.util.List;

import com.ku.spring.college.college.dto.CourseRequestDto;
import com.ku.spring.college.college.dto.CourseResponseDto;
import com.ku.spring.college.college.models.Student;
import com.ku.spring.college.college.models.Teacher;
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
import com.ku.spring.college.college.service.CourseService;

@RestController
@RequestMapping("/api/v1/courses")
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    public ResponseEntity<List<CourseResponseDto>> getAllCourses(){
        List<CourseResponseDto> courses = courseService.getAllCourse();
        return ResponseEntity.status(HttpStatus.OK).body(courses);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CourseResponseDto> getCourseById(@PathVariable Long id){
        CourseResponseDto course = courseService.getCourseById(id);
        return ResponseEntity.status(HttpStatus.OK).body(course);
    }

    @PostMapping
    public ResponseEntity<CourseResponseDto> addCourse(@RequestBody CourseRequestDto courseDto){
        CourseResponseDto addCourse = courseService.createCourse(courseDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(addCourse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CourseResponseDto> updateCourse(@PathVariable Long id, @RequestBody CourseRequestDto courseDto){
        CourseResponseDto updateCourse = courseService.updateCourse(id, courseDto);
        return ResponseEntity.status(HttpStatus.OK).body(updateCourse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCourse(@PathVariable Long id){
        courseService.deleteCourse(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping("/{courseId}/students")
    public ResponseEntity<CourseResponseDto> addStudentToCourse(@PathVariable Long courseId, @RequestBody Student student) {
        CourseResponseDto updatedCourse = courseService.addStudentToCourse(courseId, student);
        return ResponseEntity.status(HttpStatus.OK).body(updatedCourse);
    }

    @DeleteMapping("/{courseId}/students")
    public ResponseEntity<CourseResponseDto> removeStudentFromCourse(@PathVariable Long courseId, @RequestBody Student student) {
        CourseResponseDto updatedCourse = courseService.removeStudentFromCourse(courseId, student);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PutMapping("/{courseId}/teacher")
    public ResponseEntity<CourseResponseDto> assignTeacherToCourse(@PathVariable Long courseId, @RequestBody Teacher teacher) {
        CourseResponseDto updatedCourse = courseService.assignTeacherToCourse(courseId, teacher);
        return ResponseEntity.status(HttpStatus.OK).body(updatedCourse);
    }


}
