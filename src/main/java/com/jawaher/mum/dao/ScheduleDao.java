package com.jawaher.mum.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.jawaher.mum.domain.Course;
import com.jawaher.mum.domain.Faculty;
import com.jawaher.mum.domain.Schedule;


@Repository
public interface ScheduleDao  extends JpaRepository<Schedule,Long>{

	
	@Query("Select  from Schedule s  inner join s.year where  s.year= :year")
	public Schedule getScheduleByYear(@Param("year")int year);
}
