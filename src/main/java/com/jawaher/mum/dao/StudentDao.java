package com.jawaher.mum.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import com.jawaher.mum.domain.Student;


@Repository
public interface StudentDao extends JpaRepository<Student,Long> {

	
	 @Query("select s from Student s where s.email = :email")
	 public Student getStudentsByEmail(@Param("email") String studentEmail);
}
