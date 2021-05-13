package com.jawaher.mum.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jawaher.mum.dao.StudentDao;
import com.jawaher.mum.domain.Student;

import com.jawaher.mum.service.StudentService;

@Service
public class StudentServiceImp  implements StudentService{

	
	@Autowired
	StudentDao studentDao; 

	@Override
	public List<Student> findAll() {
		return  studentDao.findAll();
		
	}

	@Override
	public Student getById(Long id) {
		
		return studentDao.getOne(id) ;
	}

	@Override
	public Student getStudentByEmail(String email) {
	
		return studentDao.getStudentsByEmail(email);
	}

	@Override
	public void update(Student s) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove(Student s) {
		studentDao.delete(s);
		
	}

	@Override
	public Student save(Student s) {
		
		return studentDao.save(s);
	}

}
