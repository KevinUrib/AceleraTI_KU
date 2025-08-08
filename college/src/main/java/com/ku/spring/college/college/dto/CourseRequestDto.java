package com.ku.spring.college.college.dto;

public class CourseRequestDto {
    private String courseName;
    private int studentsQuantity;
    private String description;

    public CourseRequestDto() {
    }

    public CourseRequestDto(String courseName, int studentsQuantity, String description) {
        this.courseName = courseName;
        this.studentsQuantity = studentsQuantity;
        this.description = description;
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
}
