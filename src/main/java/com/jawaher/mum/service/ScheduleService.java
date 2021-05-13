package com.jawaher.mum.service;

import java.util.Date;
import java.util.List;

import com.jawaher.mum.domain.Schedule;

public interface ScheduleService {
	
	public List<Schedule> findAll();
    public Schedule getById(Long id);
    public Schedule getScheduleByYear(int year);
    public void update(Schedule s);
    public void remove( Schedule s);
    public Schedule save(Schedule s);

}
