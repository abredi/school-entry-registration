package com.jawaher.mum.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.jawaher.mum.domain.Block;
import com.jawaher.mum.domain.Schedule;
import com.jawaher.mum.domain.Section;


@Repository
public interface SectionDao  extends JpaRepository<Section,Long>{
	
	@Query("Select  from Section s  inner join s.block where  s.block= :block")
	public List< Section> getScheduleByBlock(@Param("block")Block block);
	
	@Query("Select  from  Section s  inner join s.number where  s.number= :number")
	public  Section getScheduleByNumber(@Param("number")int number);

}
