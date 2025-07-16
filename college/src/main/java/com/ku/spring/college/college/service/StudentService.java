package com.ku.spring.college.college.service;

import com.ku.spring.college.college.models.Course;
import com.ku.spring.college.college.models.Student;
import com.ku.spring.college.college.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class StudentService {

    private StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Transactional
    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    @Transactional
    public Student getStudentById(Long id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found with id: " + id));
    }

    @Transactional
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Transactional
    public Student updateStudent(Long id, Student studentDetails) {
        return studentRepository.findById(id)
                .map(existingStudent -> {
                    existingStudent.setName(studentDetails.getName());
                    existingStudent.setEmail(studentDetails.getEmail());
                    existingStudent.setDui(studentDetails.getDui());
                    return studentRepository.save(existingStudent);
                })
                .orElseThrow(() -> new RuntimeException("Student not found with id: " + id));
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
