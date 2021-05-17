package com.reziz.studentregistration.section.repository;

import com.reziz.studentregistration.section.domain.Section;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SectionRepository extends JpaRepository<Section, Long> {

    @Query("select s from Section s where  s.courseId=: courseId")
    List<Section> getAllByCourseId(@Param("courseId") Long courseId);
//
//    @Query("select s from Section s where s.id =: sectionId")
//    Section getBySectionId(@Param("sectionId") Long sectionId);
}
