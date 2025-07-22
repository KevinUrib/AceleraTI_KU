package com.ku.spring.college.college.service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.junit.jupiter.MockitoExtension;

import com.ku.spring.college.college.models.Teacher;
import com.ku.spring.college.college.repository.TeacherRepository;

@ExtendWith(MockitoExtension.class)
public class TeacherServiceTest {

    @Mock
    private TeacherRepository teacherRepository;

    @InjectMocks
    private TeacherService teacherService;

        @Test
    public void testCreateTeacher() {
        Teacher teacher = new Teacher();
        teacher.setTeacherName("Kevin");
        teacher.setEmail("kevin@mail.com");
        teacher.setAge(35);
        teacher.setSubject("Math");

        when(teacherRepository.save(teacher)).thenReturn(teacher);

        Teacher result = teacherService.createTeacher(teacher);
        assertEquals("Kevin", result.getTeacherName());
        verify(teacherRepository, times(1)).save(teacher);
    }


    @Test
    public void testGetTeacherById() {
        Teacher teacher = new Teacher();
        teacher.setId(1L);
        teacher.setTeacherName("Ana");

        when(teacherRepository.findById(1L)).thenReturn(Optional.of(teacher));

        Teacher result = teacherService.getTeacherById(1L);
        assertEquals("Ana", result.getTeacherName());
    }

    @Test
    public void testGetAllTeachers() {
        List<Teacher> teachers = Arrays.asList(new Teacher(), new Teacher());
        when(teacherRepository.findAll()).thenReturn(teachers);

        List<Teacher> result = teacherService.getAllTeachers();
        assertEquals(2, result.size());
    }
    
}
