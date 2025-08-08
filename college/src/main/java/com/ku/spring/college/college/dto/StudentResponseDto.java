package com.ku.spring.college.college.dto;

import com.ku.spring.college.college.models.Course;

import java.util.List;

public class StudentResponseDto {

    private Long id;
    private String nombre;
    private String email;
    private String dui;
    private List<Course> courses;

    public StudentResponseDto() {
    }

    public StudentResponseDto(Long id, String nombre, String email, String dui, List<Course> courses) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.dui = dui;
        this.courses = courses;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDui() {
        return dui;
    }

    public void setDui(String dui) {
        this.dui = dui;
    }

    public List<Course> getCourses(){
        return courses;
    }
}
