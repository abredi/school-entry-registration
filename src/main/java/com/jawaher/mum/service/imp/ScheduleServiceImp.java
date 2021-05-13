package com.jawaher.mum.service.imp;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jawaher.mum.dao.ScheduleDao;

import com.jawaher.mum.domain.Schedule;
import com.jawaher.mum.service.ScheduleService;



@Service
public class ScheduleServiceImp implements ScheduleService {
	
	@Autowired
	ScheduleDao scheduleDao; 

	@Override
	public List<Schedule> findAll() {
		
		return scheduleDao.findAll();
	}
	@Override
	public Schedule getById(Long id) {
		
		return scheduleDao.getOne(id);
	}

	@Override
	public Schedule getScheduleByYear(int year) {
	
		return scheduleDao.getScheduleByYear(year);
	}

	@Override
	public void update(Schedule s) {
	
		
	}

	@Override
	public void remove( Schedule s) {
		scheduleDao.delete(s);
		
	}

	@Override
	public Schedule save(Schedule s) {
		
		return scheduleDao.save(s);
	}

}
