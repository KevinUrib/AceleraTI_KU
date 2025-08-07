package com.ku.spring.college.college.service;

import com.ku.spring.college.college.dto.StudentRequestDto;
import com.ku.spring.college.college.dto.StudentResponseDto;
import com.ku.spring.college.college.models.Course;
import com.ku.spring.college.college.models.Student;
import com.ku.spring.college.college.repository.StudentRepository;
import com.ku.spring.college.college.utils.StudentMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class StudentService {

    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;

    public StudentService(StudentRepository studentRepository, StudentMapper studentMapper) {
        this.studentRepository = studentRepository;
        this.studentMapper = studentMapper;
    }

    @Transactional
    public StudentResponseDto createStudent(StudentRequestDto studentRequestDto) {
        Student student = studentMapper.mapToStudentRequest(studentRequestDto);
        Student savedStudent = studentRepository.save(student);
        return studentMapper.mapToStudentResponse(savedStudent);
    }

    @Transactional
    public StudentResponseDto getStudentById(Long id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found with id: " + id));
        return studentMapper.mapToStudentResponse(student);
    }

    @Transactional
    public List<StudentResponseDto> getAllStudents() {
        return studentRepository.findAll()
                .stream()
                .map(studentMapper::mapToStudentResponse)
                .toList();
    }

    @Transactional
    public StudentResponseDto updateStudent(Long id, StudentRequestDto studentRequestDto) {
       Student existingStudent = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found with id: " + id));

        existingStudent.setName(studentRequestDto.getName());
        existingStudent.setEmail(studentRequestDto.getEmail());
        existingStudent.setDui(studentRequestDto.getDui());

        Student updatedStudent = studentRepository.save(existingStudent);
        return studentMapper.mapToStudentResponse(updatedStudent);
    }

    @Transactional
    public void deleteStudent(Long id) {
        if(!studentRepository.existsById(id)){
            throw new RuntimeException("Student not found with id: " + id);
        } else {
            studentRepository.deleteById(id);
        }
    }

    @Transactional
    public Student addCoursesToStudent(Long studentId, List<Course> courses) {
        return studentRepository.findById(studentId)
                .map(student -> {
                    student.getCourses().addAll(courses);
                    courses.forEach(course -> course.getStudents().add(student)); // Aca actualizo la lista de estudiantes en cada curso
                    return studentRepository.save(student);
                })
                .orElseThrow(() -> new RuntimeException("Student not found with id: " + studentId));
    }


}
