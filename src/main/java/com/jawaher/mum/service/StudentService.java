package com.jawaher.mum.service;

import java.util.List;

import com.jawaher.mum.domain.Student;


public interface StudentService {
	
	  	public List<Student> findAll();
	    public Student getById(Long id);
	    public Student getStudentByEmail(String email);
	    public void update(Student s);
	    public void remove( Student s);
	    public Student save(Student s);

}
