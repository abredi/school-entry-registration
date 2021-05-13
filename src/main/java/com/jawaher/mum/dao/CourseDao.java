package com.jawaher.mum.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import com.jawaher.mum.domain.Course;
import com.jawaher.mum.domain.Faculty;




@Repository
public interface CourseDao extends JpaRepository<Course,Long> {
	
	 @Query("select c from Course c where c.courseName= :courseName")
	  public Course getCoursesByCourseName(@Param("courseName") String courseName);
	
	@Query("Select  from Faculty f  inner join f.course c on f.course= cousre")
	List<Faculty> getFaculty(@Param("course") Course course);
 
}
