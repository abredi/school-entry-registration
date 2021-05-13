package com.jawaher.mum.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.jawaher.mum.domain.Course;
import com.jawaher.mum.domain.Faculty;

@Repository
public interface FacultyDao  extends JpaRepository<Faculty,Long> {

	
	
	@Query("Select f.course from Faculty f " )
	 public List<Course> getCourse();
}
