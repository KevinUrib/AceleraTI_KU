package com.ku.spring.college.college.dto;

public class TeacherRequestDto {
    private String teacherName;
    private int age;
    private String email;

    public TeacherRequestDto() {
    }

    public TeacherRequestDto(String teacherName, int age, String email) {
        this.teacherName = teacherName;
        this.age = age;
        this.email = email;
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
}
