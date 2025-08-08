package com.ku.spring.college.college.service;

import com.ku.spring.college.college.dto.CourseRequestDto;
import com.ku.spring.college.college.dto.CourseResponseDto;
import com.ku.spring.college.college.models.Course;
import com.ku.spring.college.college.models.Student;
import com.ku.spring.college.college.models.Teacher;
import com.ku.spring.college.college.repository.CourseRepository;
import com.ku.spring.college.college.repository.StudentRepository;

import com.ku.spring.college.college.utils.CourseMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CourseService {
    private final CourseRepository courseRepository;
    private final StudentRepository studentRepository;
    private CourseMapper courseMapper;

    public CourseService(CourseRepository courseRepository, StudentRepository studentRepository, CourseMapper courseMapper) {
    this.courseRepository = courseRepository;
    this.studentRepository = studentRepository;
    this.courseMapper = courseMapper;
}

    // METODOS CRUD PARA CURSO
    @Transactional
    public CourseResponseDto createCourse(CourseRequestDto courseRequestDto) {
        Course course = courseMapper.mapToCourseRequest(courseRequestDto);
        Course savedCourse = courseRepository.save(course);
        return courseMapper.mapToCourseResponseDto(savedCourse);
    }

    @Transactional
    public List<CourseResponseDto> getAllCourse() {
        return courseRepository.findAll()
                .stream()
                .map(courseMapper::mapToCourseResponseDto)
                .toList();
    }

    @Transactional
    public CourseResponseDto getCourseById(Long id) {
        Course course = courseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Course not found with id: " + id));
        return courseMapper.mapToCourseResponseDto(course);
    }

    @Transactional
    public CourseResponseDto updateCourse(Long id, CourseRequestDto courseDetails) {
        Course course = courseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Course not found with id: " + id));

        course.setCourseName(courseDetails.getCourseName());
        course.setStudentsQuantity(courseDetails.getStudentsQuantity());
        course.setDescription(courseDetails.getDescription());
        Course updatedCourse = courseRepository.save(course);
        return courseMapper.mapToCourseResponseDto(updatedCourse);
    }

    @Transactional
    public void deleteCourse(Long id){
        if (!courseRepository.existsById(id)){
            throw new RuntimeException("Course not found with id: " + id);
        } else {
            courseRepository.deleteById(id);
        }
    }


    // LOGICA PARA INTERACTUAR LOS PROFESORES, ALUMNOS CON CURSOS

    // Metodo para agregar un alumno a un curso
    @Transactional
    public CourseResponseDto addStudentToCourse(Long courseId, Student student) {
        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new RuntimeException("Course not found with id: " + courseId));
        course.getStudents().add(student);
        Course updatedCourse = courseRepository.save(course);
        return courseMapper.mapToCourseResponseDto(updatedCourse);
    }

    // Metodo para quitar un alumno de un curso
    @Transactional
    public CourseResponseDto removeStudentFromCourse(Long courseId, Student student) {
        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new RuntimeException("Course not found with id: " + courseId));
        Student existingStudent = studentRepository.findById(student.getId())
                .orElseThrow(() -> new RuntimeException("Student not found with id: " + student.getId()));
        if (!course.getStudents().contains(existingStudent)) {
            throw new RuntimeException("Student not enrolled in this course");
        }
        course.getStudents().remove(existingStudent);
        Course updatedCourse = courseRepository.save(course);
        return courseMapper.mapToCourseResponseDto(updatedCourse);
    }

    // Metodo para cambiar el profesor de un curso
    @Transactional
    public CourseResponseDto assignTeacherToCourse(Long courseId, Teacher teacher) {
        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new RuntimeException("Course not found with id: " + courseId));
        course.setTeacher(teacher);
        Course updatedCourse = courseRepository.save(course);
        return courseMapper.mapToCourseResponseDto(updatedCourse);
    }





}

