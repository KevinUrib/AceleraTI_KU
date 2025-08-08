package com.ku.spring.college.college.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.mockito.ArgumentMatchers.any;
import org.mockito.InjectMocks;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.junit.jupiter.MockitoExtension;

import com.ku.spring.college.college.dto.CourseRequestDto;
import com.ku.spring.college.college.dto.CourseResponseDto;
import com.ku.spring.college.college.models.Course;
import com.ku.spring.college.college.models.Student;
import com.ku.spring.college.college.models.Teacher;
import com.ku.spring.college.college.repository.CourseRepository;
import com.ku.spring.college.college.repository.StudentRepository;
import com.ku.spring.college.college.utils.CourseMapper;

@ExtendWith(MockitoExtension.class)
class CourseServiceTest {

    @Mock
    private CourseRepository courseRepository;

    @Mock
    private StudentRepository studentRepository;

    @Mock
    private CourseMapper courseMapper;

    @InjectMocks
    private CourseService courseService;

    @Test
    void testCreateCourse() {
        Course course = new Course();
        course.setCourseName("Mathematics");

        CourseRequestDto requestDto = new CourseRequestDto("Mathematics", 20, "Basic Math Course");
        CourseResponseDto responseDto = new CourseResponseDto(1L, "Mathematics", 20, "Basic Math Course", null, null);

        when(courseMapper.mapToCourseRequest(requestDto)).thenReturn(course);
        when(courseRepository.save(course)).thenReturn(course);
        when(courseMapper.mapToCourseResponseDto(course)).thenReturn(responseDto);

        CourseResponseDto createdCourse = courseService.createCourse(requestDto);

        assertNotNull(createdCourse);
        assertEquals("Mathematics", createdCourse.getCourseName());
        verify(courseRepository, times(1)).save(course);
    }

    @Test
    void testGetAllCourses() {
        List<Course> courses = Arrays.asList(
                new Course(1L, "Mathematics", 20, "Basic Math Course", null, new ArrayList<>()));
        List<CourseResponseDto> responseDtos = Arrays.asList(
                new CourseResponseDto(1L, "Mathematics", 20, "Basic Math Course", null, null));

        when(courseRepository.findAll()).thenReturn(courses);
        when(courseMapper.mapToCourseResponseDto(courses.get(0))).thenReturn(responseDtos.get(0));

        List<CourseResponseDto> foundCourses = courseService.getAllCourse();

        assertEquals(1, foundCourses.size());
        verify(courseRepository).findAll();
    }

    @Test
    void testGetCourseById() {
        Course course = new Course(1L, "Mathematics", 20, "Basic Math Course", null, new ArrayList<>());
        CourseResponseDto responseDto = new CourseResponseDto(1L, "Mathematics", 20, "Basic Math Course", null, null);

        when(courseRepository.findById(1L)).thenReturn(Optional.of(course));
        when(courseMapper.mapToCourseResponseDto(course)).thenReturn(responseDto);

        CourseResponseDto foundCourse = courseService.getCourseById(1L);

        assertEquals("Mathematics", foundCourse.getCourseName());
    }

    @Test
    void testGetCourseById_WhenNotFound() {
        when(courseRepository.findById(1L)).thenReturn(Optional.empty());

        RuntimeException exception = assertThrows(RuntimeException.class, () -> courseService.getCourseById(1L));
        assertEquals("Course not found with id: 1", exception.getMessage());
    }

    @Test
    void testAddStudentToCourse() {
        Student student = new Student(1L, "John", "john@mail.com", "123456789", new ArrayList<>());
        Course course = new Course(1L, "Math", 30, "Intro Math", null, new ArrayList<>());
        CourseResponseDto responseDto = new CourseResponseDto(1L, "Math", 30, "Intro Math", null, null);

        when(courseRepository.findById(1L)).thenReturn(Optional.of(course));
        when(courseRepository.save(any())).thenReturn(course);
        when(courseMapper.mapToCourseResponseDto(course)).thenReturn(responseDto);

        CourseResponseDto updated = courseService.addStudentToCourse(1L, student);

        assertTrue(course.getStudents().contains(student));
    }

    @Test
    void testAssignTeacherToCourse() {
        Teacher teacher = new Teacher(1L, "Jane", 35, "jane@mail.com", null, null);
        Course course = new Course(1L, "Math", 30, "Intro Math", null, new ArrayList<>());
        CourseResponseDto responseDto = new CourseResponseDto(1L, "Math", 30, "Intro Math", "Jane", null);

        when(courseRepository.findById(1L)).thenReturn(Optional.of(course));
        when(courseRepository.save(any())).thenReturn(course);
        when(courseMapper.mapToCourseResponseDto(course)).thenReturn(responseDto);

        CourseResponseDto updated = courseService.assignTeacherToCourse(1L, teacher);

        assertEquals("Jane", updated.getTeacherName());
    }
}