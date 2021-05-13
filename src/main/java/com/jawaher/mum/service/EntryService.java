package com.jawaher.mum.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.jawaher.mum.domain.Entry;



public interface EntryService {
	
	public List<Entry> findAll();
    public Optional <Entry> getById(Long id);
    public Entry getEntryByStartDate(Date startDate);
    public void update(Entry s);
    public void remove( Entry s);
    public Entry save(Entry s);

}
