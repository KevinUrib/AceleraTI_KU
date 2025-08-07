package com.ku.spring.college.college.utils;

import com.ku.spring.college.college.dto.TeacherRequestDto;
import com.ku.spring.college.college.dto.TeacherResponseDto;
import com.ku.spring.college.college.models.Teacher;

public class TeacherMapper {

    public Teacher mapToTeacherRequest(TeacherRequestDto teacherRequestDto){
        if (teacherRequestDto == null){
            return null;
        }
        Teacher teacher = new Teacher();
        teacher.setTeacherName(teacherRequestDto.getTeacherName());
        teacher.setAge(teacherRequestDto.getAge());
        teacher.setEmail(teacherRequestDto.getEmail());
        return teacher;
    }

    public TeacherResponseDto mapToTeacherResponse(Teacher teacher){
        if(teacher == null){
            return null;
        }
        return new TeacherResponseDto(
                teacher.getId(),
                teacher.getTeacherName(),
                teacher.getAge(),
                teacher.getEmail(),
                teacher.getSubject(),
                teacher.getCourse()
        );
    }





}
