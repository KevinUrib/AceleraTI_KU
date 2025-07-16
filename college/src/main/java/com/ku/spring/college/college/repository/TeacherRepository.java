package com.ku.spring.college.college.repository;

import com.ku.spring.college.college.models.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {
    // Additional query methods can be defined here if needed
}
