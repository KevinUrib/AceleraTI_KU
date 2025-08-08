package com.ku.spring.college.college.utils;

import com.ku.spring.college.college.dto.CourseRequestDto;
import com.ku.spring.college.college.dto.CourseResponseDto;
import com.ku.spring.college.college.models.Course;
import com.ku.spring.college.college.models.Student;

import java.util.List;
import java.util.stream.Collectors;

public class CourseMapper {

    public Course mapToCourseRequest(CourseRequestDto courseRequestDto){
        if (courseRequestDto == null){
            return null;
        }
        Course course = new Course();
        course.setCourseName(courseRequestDto.getCourseName());
        course.setStudentsQuantity(courseRequestDto.getStudentsQuantity());
        course.setDescription(courseRequestDto.getDescription());
        return course;
    }

    public CourseResponseDto mapToCourseResponseDto(Course course) {
        String teacherName = course.getTeacher() != null ? course.getTeacher().getTeacherName() : null;
        List<String> studentNames = course.getStudents().stream()
                .map(Student::getName)
                .collect(Collectors.toList());

        return new CourseResponseDto(
                course.getId(),
                course.getCourseName(),
                course.getStudentsQuantity(),
                course.getDescription(),
                teacherName,
                studentNames
        );
    }




}
