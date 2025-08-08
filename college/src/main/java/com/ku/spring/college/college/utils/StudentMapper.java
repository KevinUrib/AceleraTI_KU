package com.ku.spring.college.college.utils;

import com.ku.spring.college.college.dto.StudentRequestDto;
import com.ku.spring.college.college.dto.StudentResponseDto;
import com.ku.spring.college.college.models.Student;

public class StudentMapper {

    public Student mapToStudentRequest(StudentRequestDto studentRequestDto) {
        if (studentRequestDto == null) {
            return null;
        }
        Student student = new Student();
        student.setName(studentRequestDto.getName());
        student.setEmail(studentRequestDto.getEmail());
        student.setDui(studentRequestDto.getDui());
        return student;
    }

    public StudentResponseDto mapToStudentResponse(Student student) {
        if (student == null) {
            return null;
        }
        return new StudentResponseDto(
                student.getId(),
                student.getName(),
                student.getEmail(),
                student.getDui(),
                student.getCourses()
        );
    }


}
