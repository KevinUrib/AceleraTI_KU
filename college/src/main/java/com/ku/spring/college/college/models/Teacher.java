package com.ku.spring.college.college.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import java.util.List;

@Entity
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Teacher name is mandatory")
    private String teacherName;
    @Min(value = 18, message = "Age must be at least 18")
    private int age;
    @Email(message = "Email should be valid")
    private String email;
    @NotBlank(message = "Subject is mandatory")
    private String subject;
    @OneToMany(mappedBy = "teacher", cascade = CascadeType.ALL)
    private List<Course> course;

    public Teacher() {
    }

    public Teacher(Long id, String teacherName, int age, String email, String subject, List<Course> course) {
        this.id = id;
        this.teacherName = teacherName;
        this.age = age;
        this.email = email;
        this.subject = subject;
        this.course = course;
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

    public List<Course> getCourse() {
        return course;
    }

    public void setCourse(List<Course> course) {
        this.course = course;
    }
}
