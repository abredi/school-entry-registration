package com.jawaher.mum.service;


import java.util.List;
import java.util.Optional;

import com.jawaher.mum.domain.Block;

import com.jawaher.mum.domain.Section;

public interface BlockService {
	
	public List<Block> findAll();
    public Optional<Block> getById(Long id);
    public List<Section> getSectionByBlock(Block block);
    public void update(Block s);
    public void remove( Block s);
    public Block save(Block s);

}
