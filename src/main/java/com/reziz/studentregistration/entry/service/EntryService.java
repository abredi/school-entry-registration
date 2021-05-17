package com.reziz.studentregistration.entry.service;

import com.reziz.studentregistration.entry.domain.Entry;
import com.reziz.studentregistration.entry.repository.EntryRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.List;

@Service
@Validated
@AllArgsConstructor
public class EntryService {
    @Autowired
    private final EntryRepository entryRepository;
    public Entry save(@Valid Entry entry) {
        return entryRepository.save(entry);
    }

    public Entry findById(Long id) {
        return entryRepository.findById(id).orElseGet(Entry::new);
    }
    
    public Entry getEntryByEntryID(Long id) {
        return entryRepository.findById(id).orElseGet(Entry::new);
    }

    public Entry getEntryByEntryName(String entryName) {
        return entryRepository.findEntryByEntryName(entryName);
    }

    public List<Entry> getAllEntry() {
        return entryRepository.findAll();
    }
}
