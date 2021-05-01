package com.reziz.studentregistration.block.service;

import com.reziz.studentregistration.block.domain.Block;
import com.reziz.studentregistration.block.repository.BlockRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.List;

@Service
@Validated
@AllArgsConstructor
public class BlockService {
    private final BlockRepository entryRepository;
    public Block save(@Valid Block entry) {
        return entryRepository.save(entry);
    }

    public Block findById(Long id) {
        return entryRepository.findById(id).orElseGet(Block::new);
    }
    
    public Block getEntryByEntryID(Long id) {
        return entryRepository.findById(id).orElseGet(Block::new);
    }

    public Block getBlockByBlockName(String entryName) {
        return entryRepository.findBlockByBlockName(entryName);
    }

    public List<Block> getAllBlock() {
        return entryRepository.findAll();
    }
}
