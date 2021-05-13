package com.jawaher.mum.service.imp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jawaher.mum.dao.BlockDao;
import com.jawaher.mum.domain.Block;
import com.jawaher.mum.domain.Section;
import com.jawaher.mum.service.BlockService;

@Service
public class BlockServiceImp implements BlockService{
	
	@Autowired
	BlockDao blockDao; 
	
	

	@Override
	public List<Block> findAll() {
		return blockDao.findAll() ;
	}

	@Override
	public Optional<Block> getById(Long id) {
		return blockDao.findById(id);
	}

	@Override
	public List<Section> getSectionByBlock(Block block) {
		
		return blockDao.getSectionByBlock(block.getBlockID());
	}

	@Override
	public void update(Block s) {
		//to do
		
	}

	@Override
	public void remove( Block s) {
		blockDao.delete(s);
		
	}

	@Override
	public Block save(Block s) {
		blockDao.save(s);
		return null;
	}

}
