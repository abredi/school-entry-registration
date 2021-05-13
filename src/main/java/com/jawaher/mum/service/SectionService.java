package com.jawaher.mum.service;

import java.util.List;

import com.jawaher.mum.domain.Block;
import com.jawaher.mum.domain.Section;



public interface SectionService {
	
	public List<Section> findAll();
    public Section getById(Long id);
    public Section getSectionByNumber(int number);
    public List<Section> getSectionByBlock(Block b);
    
    public void update(Section s);
    public void remove(Section s);
    public Section save(Section s);

}
