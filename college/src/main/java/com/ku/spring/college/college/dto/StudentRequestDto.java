package com.ku.spring.college.college.dto;


public class StudentRequestDto {

    private String name;
    private String email;
    private String dui;

    public StudentRequestDto() {
    }

    public StudentRequestDto(String name, String email, String dui) {
        this.name = name;
        this.email = email;
        this.dui = dui;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
}
