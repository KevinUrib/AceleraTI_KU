package com.ku.spring.college.college.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.junit.jupiter.MockitoExtension;

import com.ku.spring.college.college.models.Student;
import com.ku.spring.college.college.repository.StudentRepository;

@ExtendWith(MockitoExtension.class)
public class StudentServiceTest {

    @Mock
    private StudentRepository studentRepository;

    @InjectMocks
    private StudentService studentService;

    @Test
    void testCreateStudent(){
        Student student = new Student();
        student.setName("Kevin");
        student.setEmail("kevin@mail.com");
        student.setDui("987654321");

        when(studentRepository.save(student)).thenReturn(student);
        Student createdStudent = studentService.createStudent(student);

        assertNotNull(createdStudent);
        assertEquals("Kevin", createdStudent.getName());
        assertEquals("kevin@mail.com", createdStudent.getEmail());
        assertEquals("987654321", createdStudent.getDui());
        verify(studentRepository, times(1)).save(createdStudent);
    }

    @Test
    void testGetAllStudents(){
        List<Student> students = Arrays.asList(
            new Student(1L, "Kevin", "kevin@mail.com", "987654321",  new ArrayList<>()),
            new Student(2L, "Alice", "alice@mail.com", "123456789", new ArrayList<>())
        );

        when(studentRepository.findAll()).thenReturn(students);
        List<Student> foundStudents = studentService.getAllStudents();

        assertEquals(2, foundStudents.size());
        verify(studentRepository).findAll();
    }

    @Test
    void testGetStudentById(){
        Student student = new Student(1L, "Kevin", "kevin@mail.com", "987654321",  new ArrayList<>());
        when(studentRepository.findById(1L)).thenReturn(Optional.of(student));

        Student foundStudent = studentService.getStudentById(1L);

        assertEquals("Kevin", foundStudent.getName());    
    }

 

}
