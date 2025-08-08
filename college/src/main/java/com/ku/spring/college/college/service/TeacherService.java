package com.ku.spring.college.college.service;

import com.ku.spring.college.college.dto.TeacherRequestDto;
import com.ku.spring.college.college.dto.TeacherResponseDto;
import com.ku.spring.college.college.models.Course;
import com.ku.spring.college.college.models.Teacher;
import com.ku.spring.college.college.repository.TeacherRepository;
import com.ku.spring.college.college.utils.TeacherMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TeacherService {
    private final TeacherRepository teacherRepository;
    private TeacherMapper teacherMapper;

    public TeacherService(TeacherRepository teacherRepository, TeacherMapper teacherMapper) {
        this.teacherRepository = teacherRepository;
        this.teacherMapper = teacherMapper;
    }

    @Transactional
    public TeacherResponseDto createTeacher(TeacherRequestDto teacherRequestDto) {
        Teacher teacher = teacherMapper.mapToTeacherRequest(teacherRequestDto);
        Teacher savedTeacher = teacherRepository.save(teacher);
        return teacherMapper.mapToTeacherResponse(savedTeacher);
    }

    @Transactional
    public TeacherResponseDto getTeacherById(Long id) {
        Teacher teacher = teacherRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Teacher not found with id: " + id));
    return teacherMapper.mapToTeacherResponse(teacher);
    }

    @Transactional
    public List<TeacherResponseDto> getAllTeachers(){
        return teacherRepository.findAll()
                .stream()
                .map(teacherMapper::mapToTeacherResponse)
                .toList();
    }

    @Transactional
    public TeacherResponseDto updateTeacher(Long id, TeacherRequestDto teacherDetails){
        Teacher existingTeacher = teacherRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Teacher not found with id: " + id));

        existingTeacher.setTeacherName(teacherDetails.getTeacherName());
        existingTeacher.setAge(teacherDetails.getAge());
        existingTeacher.setEmail(teacherDetails.getEmail());

        Teacher updatedTeacher = teacherRepository.save(existingTeacher);
        return teacherMapper.mapToTeacherResponse(updatedTeacher);
    }

    @Transactional
    public void deleteTeacher(Long id) {
        if (!teacherRepository.existsById(id)) {
            throw new RuntimeException("Teacher not found with id: " + id);
        } else {
            teacherRepository.deleteById(id);
        }
    }

    @Transactional
    public Teacher addTeacherToCourse(Long teacherId, List<Course> courses){
        return teacherRepository.findById(teacherId)
                .map(teacher -> {
                    teacher.getCourse().addAll(courses);
                    courses.forEach(course -> course.setTeacher(teacher)); // Aca establezco al profesor en cada curso
                    return teacherRepository.save(teacher);
                })
                .orElseThrow(() -> new RuntimeException("Teacher not found with id: " + teacherId));
    }



}
