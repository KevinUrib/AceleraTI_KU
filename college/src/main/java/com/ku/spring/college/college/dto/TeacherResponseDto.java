package com.ku.spring.college.college.dto;

import com.ku.spring.college.college.models.Course;

import java.util.List;

public class TeacherResponseDto {
    private Long id;
    private String teacherName;
    private int age;
    private String email;
    private String subject;
    private List<Course> courses;

    public TeacherResponseDto() {
    }

    public TeacherResponseDto(Long id, String teacherName, int age, String email, String subject, List<Course> courses) {
        this.id = id;
        this.teacherName = teacherName;
        this.age = age;
        this.email = email;
        this.subject = subject;
        this.courses = courses;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public List<Course> getCourses() {
        return courses;
    }
}
