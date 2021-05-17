package com.reziz.studentregistration.block.repository;

import com.reziz.studentregistration.block.domain.Block;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlockRepository extends JpaRepository<Block, Long> {
    Block findBlockByBlockName(String entryName);
}
