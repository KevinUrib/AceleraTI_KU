package com.ku.spring.college.college.dto;

import java.util.List;

public class CourseResponseDto {
    private Long id;
    private String courseName;
    private int studentsQuantity;
    private String description;
    private String teacherName; // Simplified teacher information
    private List<String> studentNames; // Simplified student information

    public CourseResponseDto() {
    }

    public CourseResponseDto(Long id, String courseName, int studentsQuantity, String description, String teacherName, List<String> studentNames) {
        this.id = id;
        this.courseName = courseName;
        this.studentsQuantity = studentsQuantity;
        this.description = description;
        this.teacherName = teacherName;
        this.studentNames = studentNames;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getStudentsQuantity() {
        return studentsQuantity;
    }

    public void setStudentsQuantity(int studentsQuantity) {
        this.studentsQuantity = studentsQuantity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public List<String> getStudentNames() {
        return studentNames;
    }

    public void setStudentNames(List<String> studentNames) {
        this.studentNames = studentNames;
    }
}