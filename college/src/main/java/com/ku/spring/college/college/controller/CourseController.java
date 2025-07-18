package com.ku.spring.college.college.controller;

import java.util.List;

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
    public ResponseEntity<List<Course>> getAllCourses(){
        List<Course> courses = courseService.getAllCourse();
        return ResponseEntity.status(HttpStatus.OK).body(courses);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Course> getCourseById(@PathVariable Long id){
        Course course = courseService.getCourseById(id);
        return ResponseEntity.status(HttpStatus.OK).body(course);
    }

    @PostMapping
    public ResponseEntity<Course> addCourse(@RequestBody Course course){
        Course addCourse = courseService.createCourse(course);
        return ResponseEntity.status(HttpStatus.CREATED).body(addCourse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Course> updateCourse(@PathVariable Long id, @RequestBody Course courseDetails){
        Course updateCourse = courseService.updateCourse(id, courseDetails);
        return ResponseEntity.status(HttpStatus.OK).body(updateCourse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCourse(@PathVariable Long id){
        courseService.deleteCourse(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


}
