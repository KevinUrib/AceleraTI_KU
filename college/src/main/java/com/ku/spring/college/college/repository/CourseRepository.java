package com.ku.spring.college.college.repository;

import com.ku.spring.college.college.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
