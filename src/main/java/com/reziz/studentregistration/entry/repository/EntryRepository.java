package com.reziz.studentregistration.entry.repository;

import com.reziz.studentregistration.entry.domain.Entry;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EntryRepository extends JpaRepository<Entry, Long> {
    Entry findEntryByEntryName(String entryName);
}

