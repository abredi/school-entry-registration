package com.jawaher.mum.dao;

import java.util.Date;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import com.jawaher.mum.domain.Entry;

@Repository
public interface EntryDao extends JpaRepository<Entry,Long>{
	
	@Query ("select e.section from Entry e where b.startDate = :startDate")
	Entry getEntryByStartDate(@Param("startDate")Date startDate);

}
