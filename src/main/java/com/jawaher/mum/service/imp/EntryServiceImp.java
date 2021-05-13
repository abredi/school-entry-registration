package com.jawaher.mum.service.imp;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jawaher.mum.dao.EntryDao;
import com.jawaher.mum.domain.Entry;
import com.jawaher.mum.service.EntryService;

@Service
public class EntryServiceImp  implements EntryService {
	
	@Autowired
	EntryDao entryDao; 

	@Override
	public List<Entry> findAll() {
		return entryDao.findAll();
	}

	@Override
	public Optional<Entry> getById(Long id) {
		
		return entryDao.findById(id);
	}

	@Override
	public Entry getEntryByStartDate(Date startDate) {
		
		return entryDao.getEntryByStartDate(startDate);
	}

	@Override
	public void update(Entry s) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove(Entry s) {
		entryDao.delete(s);
		
	}

	@Override
	public Entry save(Entry s) {
		return entryDao.save(s);
		
	}

}
