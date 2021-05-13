package com.reziz.studentregistration.course.repository;

import com.reziz.studentregistration.course.domain.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
    Course findEntryByName(String entryName);
}

