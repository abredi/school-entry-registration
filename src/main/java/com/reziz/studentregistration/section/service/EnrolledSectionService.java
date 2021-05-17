package com.reziz.studentregistration.section.service;

import com.reziz.studentregistration.section.domain.EnrolledSection;
import com.reziz.studentregistration.section.domain.Section;
import com.reziz.studentregistration.section.repository.EnrolledSectionRepository;
import com.reziz.studentregistration.student.domain.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnrolledSectionService {
    @Autowired
    private EnrolledSectionRepository enrolledSectionRepository;

    public EnrolledSection saveStudentToSection(Long sectionId, Long studentId){
        EnrolledSection enrolledSection = new EnrolledSection();
        enrolledSection.setSectionId(sectionId);
        enrolledSection.setStudentId(studentId);
        return  enrolledSectionRepository.save(enrolledSection);
    }
//    public EnrolledSection getSectionBySectionIdAndStudentId(Long studentId, Long sectionId){
//        return enrolledSectionRepository.getEnrolledSectionByStudentId(studentId, sectionId);
//    }
}
