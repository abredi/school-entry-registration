package com.reziz.studentregistration.student.repository;

import com.reziz.studentregistration.student.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
