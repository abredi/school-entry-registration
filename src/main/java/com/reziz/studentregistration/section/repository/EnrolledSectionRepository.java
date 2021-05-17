package com.reziz.studentregistration.section.repository;

import com.reziz.studentregistration.section.domain.EnrolledSection;
import com.reziz.studentregistration.section.domain.Section;
import com.reziz.studentregistration.student.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface EnrolledSectionRepository extends JpaRepository<EnrolledSection, Long> {

    @Query("select s from Student s where  s.id=: studentId")
    List<Student> getAllByCourseId(@Param("studentId") Long studentId);

    @Query("select s from Section s where s.id=: sectionId")
    Section getSection(@Param("sectionId") Long studentId);

}
