package com.ku.spring.college.college.service;

import com.ku.spring.college.college.models.Course;
import com.ku.spring.college.college.models.Teacher;
import com.ku.spring.college.college.repository.TeacherRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TeacherService {
    private TeacherRepository teacherRepository;

    public TeacherService(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    @Transactional
    public Teacher createTeacher(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    @Transactional
    public Teacher getTeacherById(Long id) {
        return teacherRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Teacher not found with id: " + id));
    }

    @Transactional
    public List<Teacher> getAllTeachers(){
        return teacherRepository.findAll();
    }

    @Transactional
    public Teacher updateTeacher(Long id, Teacher teacherDetails){
        return teacherRepository.findById(id)
                .map(existingTeacher -> {
                    existingTeacher.setTeacherName(teacherDetails.getTeacherName());
                    existingTeacher.setAge(teacherDetails.getAge());
                    existingTeacher.setEmail(teacherDetails.getEmail());
                    existingTeacher.setSubject(teacherDetails.getSubject());
                    return teacherRepository.save(existingTeacher);
                })
                .orElseThrow(() -> new RuntimeException("Teacher not found with id: " + id));
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
