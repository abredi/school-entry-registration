package com.jawaher.mum.service.imp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jawaher.mum.dao.FacultyDao;

import com.jawaher.mum.domain.Course;
import com.jawaher.mum.domain.Faculty;

import com.jawaher.mum.service.FacultyService;

@Service
public class FacultyServiceImp implements FacultyService {
	
	@Autowired
	FacultyDao facultyDao; 

	@Override
	public List<Faculty> findAll() {
		
		return facultyDao.findAll();
	}

	@Override
	public Optional<Faculty> getById(Long id) {
		return facultyDao.findById(id);
	}

	@Override
	public List<Course> getCourse() {
		
		return facultyDao.getCourse() ;
	}

	@Override
	public void update(Faculty s) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove( Faculty s) {
		facultyDao.delete(s);
		
	}

	@Override
	public Faculty save(Faculty s) {
		
		return facultyDao.save(s);
	}

}
