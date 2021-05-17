package com.reziz.studentregistration.block.repository;

import com.reziz.studentregistration.block.domain.BlockRegCourse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlockRegCourseRepository extends JpaRepository<BlockRegCourse, Long> {
}
