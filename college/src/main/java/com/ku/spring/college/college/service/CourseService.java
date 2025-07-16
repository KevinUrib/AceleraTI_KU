package com.ku.spring.college.college.service;

import com.ku.spring.college.college.models.Course;
import com.ku.spring.college.college.models.Student;
import com.ku.spring.college.college.models.Teacher;
import com.ku.spring.college.college.repository.CourseRepository;
import com.ku.spring.college.college.repository.StudentRepository;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CourseService {
    private CourseRepository courseRepository;
    private StudentRepository studentRepository;

    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public CourseService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    // METODOS CRUD PARA CURSO
    @Transactional
    public Course createCourse(Course course) {
        return courseRepository.save(course);
    }

    //@Transactional
    public List<Course> getAllCourse() {
        return courseRepository.findAll();
    }

    //@Transactional
    public Course getCourseById(Long id) {
        return courseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Course not found with id: " + id));
    }

    @Transactional
    public Course updateCourse(Long id, Course courseDetails) {
        return courseRepository.findById(id)
                .map(existingCourse -> {
                    existingCourse.setCourseName(courseDetails.getCourseName());
                    existingCourse.setStudentsQuantity(courseDetails.getStudentsQuantity());
                    existingCourse.setDescription(courseDetails.getDescription());
                    existingCourse.setTeacher(courseDetails.getTeacher());
                    existingCourse.setStudents(courseDetails.getStudents());
                    return courseRepository.save(existingCourse);
                })
                .orElseThrow(() -> new RuntimeException("Course not found with id: " + id));
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
    public Course addStudentToCourse(Long courseId, Student student){
        Course course = getCourseById(courseId);
        course.getStudents().add(student);
        return courseRepository.save(course);
    }

    // Metodo para quitar un alumno de un curso
    @Transactional
    public Course removeStudentFromCourse(Long courseId, Student student){
        Course course = getCourseById(courseId);
        Student existingStudent = studentRepository.findById(student.getId())
                .orElseThrow(() -> new RuntimeException("Student not found with id: " + student.getId()));
                if (!course.getStudents().contains(existingStudent)) {
                    throw new RuntimeException("Student not enrolled in this course");
                }
                course.getStudents().remove(existingStudent);
                return courseRepository.save(course);
    }

    // Metodo para cambiar el profesor de un curso
    @Transactional
    public Course assignTeacherToCourse(Long courseId, Teacher teacher){
        Course course = getCourseById(courseId);
        course.setTeacher(teacher);
        return courseRepository.save(course);

    }





}

