package com.reziz.studentregistration.course.repository;

import com.reziz.studentregistration.course.domain.Course;
import com.reziz.studentregistration.course.domain.Prerequisite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PrerequisiteRepository extends JpaRepository<Prerequisite, Long> {
}

