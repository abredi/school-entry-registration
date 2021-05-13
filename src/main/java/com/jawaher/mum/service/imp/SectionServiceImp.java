package com.jawaher.mum.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jawaher.mum.dao.SectionDao;
import com.jawaher.mum.domain.Block;
import com.jawaher.mum.domain.Section;
import com.jawaher.mum.service.SectionService;



@Service
public class SectionServiceImp  implements SectionService{
	
	@Autowired
	SectionDao sectionDao; 

	@Override
	public List<Section> findAll() {
		return sectionDao.findAll();
		
	}
	@Override
	public Section getById(Long id) {
	
		return sectionDao.getOne(id) ;
	}

	@Override
	public List <Section> getSectionByBlock(Block b) {
		return sectionDao.getScheduleByBlock(b);
		
	}

	@Override
	public void update(Section s) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove( Section s) {
		sectionDao.delete(s);
		
	}

	@Override
	public Section save(Section s) {
	
		return sectionDao.save(s);
	}
	@Override
	public Section getSectionByNumber(int number) {
		
		return sectionDao.getScheduleByNumber(number);
	}

}
