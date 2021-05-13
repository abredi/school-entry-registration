package com.reziz.studentregistration.course.repository;

import com.reziz.studentregistration.course.domain.Course;
import com.reziz.studentregistration.course.domain.Prerequisite;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrerequisiteRepository extends JpaRepository<Prerequisite, Long> {
}

