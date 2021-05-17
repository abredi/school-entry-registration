package com.reziz.studentregistration.faculty.service;


import com.reziz.studentregistration.faculty.domain.Faculty;
import com.reziz.studentregistration.faculty.repository.FacultyRepository;
import com.reziz.studentregistration.section.domain.Section;
import com.reziz.studentregistration.section.repository.SectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;
@Service
public class FacultyService {
    @Autowired
    private FacultyRepository facultyRepository;
    public Faculty save(@Valid Faculty faculty) {
        return facultyRepository.save(faculty);
    }

    public Faculty findById(Long id) {
        return facultyRepository.findById(id).orElseGet(Faculty::new);
    }

    public Faculty getFacultyBySFacultyID(Long id) {
        return facultyRepository.findById(id).orElseGet(Faculty::new);
    }

    public List<Faculty> getAllFaculty() {
        return facultyRepository.findAll();
    }
}

