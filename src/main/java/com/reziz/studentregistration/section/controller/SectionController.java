package com.reziz.studentregistration.section.controller;

import com.reziz.studentregistration.block.domain.Block;
import com.reziz.studentregistration.block.service.BlockService;
import com.reziz.studentregistration.course.domain.Course;
import com.reziz.studentregistration.course.service.CourseService;
import com.reziz.studentregistration.faculty.domain.Faculty;
import com.reziz.studentregistration.faculty.service.FacultyService;
import com.reziz.studentregistration.section.domain.Section;
import com.reziz.studentregistration.section.service.EnrolledSectionService;
import com.reziz.studentregistration.section.service.SectionService;
import com.reziz.studentregistration.student.domain.Student;
import com.reziz.studentregistration.student.service.StudentService;
import com.reziz.studentregistration.util.SectionHelp;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Controller
@RequestMapping("/section")
public class SectionController {

    @Autowired
    private SectionService sectionService;
    @Autowired
    private BlockService blockService;
    @Autowired
    private FacultyService facultyService;
    @Autowired
    private StudentService studentService;
    @Autowired
    private CourseService courseService;
    @Autowired
    ObjectFactory<HttpSession> httpSessionObjectFactory;
    @Autowired
    private EnrolledSectionService enrolledSectionService;

    @GetMapping("/all")
    public String all(Model model) {
        List<SectionHelp> sectionData = sectionService.dataList();
        model.addAttribute("sectionRec", sectionData);
        return "section/sectionlist";
    }

    @GetMapping("/registertosection/{id}")
    public String registeringToSeciont(@PathVariable Long id, Model model) {
        String message = sectionService.registerStudentToSection(id);
        model.addAttribute("message", message);
        return "section/studentsectionForm";
    }
    @GetMapping("/mysections")
    public String viewStucentCurrentSections(Model model) {
        List<SectionHelp> sectionData = sectionService.dataForStudentList();
        model.addAttribute("sectionRec", sectionData);

        return "section/mycurrentsections";

    }

}
