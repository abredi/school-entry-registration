package com.jawaher.mum.service.imp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jawaher.mum.dao.CourseDao;

import com.jawaher.mum.domain.Course;
import com.jawaher.mum.domain.Faculty;
import com.jawaher.mum.service.CourseService;


@Service
public class CourseServiceImp implements CourseService {
	
	@Autowired
	CourseDao courseDao; 

	@Override
	public List<Course> findAll() {
		return courseDao.findAll();
	}
 
	@Override
	public Optional<Course> getById(Long id) {
		
		return courseDao.findById(id);
	}

	@Override
	public List<Faculty> getFaculty(String courseName) {
		return courseDao.getFaculty( getCourseByCourseName(courseName));
		
	}

	@Override
	public void update(Course s) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove( Course s) {
		
		courseDao.delete(s);
		
	}

	@Override
	public Course save(Course s) {
		// TODO Auto-generated method stub
		return courseDao.save(s);
	}

	@Override
	public Course getCourseByCourseName(String courseName) {
		return courseDao.getCoursesByCourseName(courseName);
	}

}
