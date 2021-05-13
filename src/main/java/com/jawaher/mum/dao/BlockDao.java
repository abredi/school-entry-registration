package com.jawaher.mum.dao;




import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.jawaher.mum.domain.Block;
import com.jawaher.mum.domain.Section;





@Repository
public interface BlockDao  extends JpaRepository<Block,Long> {
	
	@Query ("select b.section from Block b where b.id = :id")
	List<Section> getSectionByBlock(@Param("id") Long blockID);
	
	
	
	
		

}
