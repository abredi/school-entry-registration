package com.reziz.studentregistration.section.service;

import com.reziz.studentregistration.block.domain.Block;
import com.reziz.studentregistration.block.service.BlockService;
import com.reziz.studentregistration.course.domain.Course;
import com.reziz.studentregistration.course.service.CourseService;
import com.reziz.studentregistration.faculty.domain.Faculty;
import com.reziz.studentregistration.faculty.service.FacultyService;
import com.reziz.studentregistration.section.domain.EnrolledSection;
import com.reziz.studentregistration.section.domain.Section;
import com.reziz.studentregistration.section.repository.SectionRepository;
import com.reziz.studentregistration.student.domain.Student;
import com.reziz.studentregistration.student.service.StudentService;
import com.reziz.studentregistration.util.SectionHelp;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Service
public class SectionService {
    @Autowired
    private SectionRepository sectionRepository;
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

    public Section save(@Valid Section section) {
        return sectionRepository.save(section);
    }

    public Section findById(Long id) {
        return sectionRepository.findById(id).orElseGet(Section::new);
    }

    public Section getSectionBySectionID(Long id) {
        return sectionRepository.findById(id).orElseGet(Section::new);
    }

    public List<Section> getAllSection() {
        return sectionRepository.findAll();
    }
    public List<Section> getAllSectionByCourseId(Long courseId){ return  sectionRepository.getAllByCourseId(courseId); }

    public List<SectionHelp> dataList(){
        List<Section> sectionRec = sectionRepository.findAll();
        List<SectionHelp> sectionData = new ArrayList<>();

        for (Section section: sectionRec) {
            SectionHelp shelper = new SectionHelp();
            shelper.setSection(section);
            long facultyId = section.getFacultyId();
            Faculty faculty = facultyService.findById(facultyId);
            shelper.setFaculty(faculty);
            long blockId = section.getBlockId();
            Block block = blockService.findById(blockId);
            shelper.setBlock(block);
            long courseId = section.getCourseId();
            Course course = courseService.findById(courseId);
            shelper.setCourse(course);
            List<Student> studentl = section.getStudent();
            for(Student student: studentl){shelper.addStudent(student);}
            sectionData.add((shelper));
        }
        return sectionData;
    }

    public String registerStudentToSection(Long sectionId){
        String message = "No action made";
        String username;
        Long stuId;

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            username = ((UserDetails) principal).getUsername();
        } else {
            username = principal.toString();
        }
        Student sesStu = studentService.findStudentByEmail(username);
        stuId = sesStu.getId();

        //Verify if student has already registered this section
        List<Section> secStuList = sesStu.getSections();
        boolean isInSection = false;
        for(Section s: secStuList) {
            if (s.getId() == sectionId) {
                isInSection = true;
                message = "You are already registered in this section";
                break;
            }
        }

        if (isInSection == false){
            //Verify if student has already register another section with the same course
            boolean hasOtherSectionSameCourse = false;
            Section currentSec = sectionRepository.getOne(sectionId);
            for(Section s: secStuList) {
                //enrolledSectionService.g
                if(s.getCourseId() == currentSec.getCourseId()){
                    hasOtherSectionSameCourse = true;
                    Block block = blockService.findById(currentSec.getBlockId());
                    message = "You are already registered into other section for the same course (Section '" + block.getBlockName() + "')";
                }
            }

            if(!hasOtherSectionSameCourse){
                //Verify if student is trying to register a section with a course that required prerequisite
                Course cour = courseService.findById(currentSec.getCourseId());
                List<Course> pre = cour.getPrerequisite();
                if (pre.isEmpty()){
                    enrolledSectionService.saveStudentToSection(sectionId, stuId);
                    message = "You registered to section successfully";
                }else {
                    //TODO: Check if the student complies with on the prerequisites.
                    //If he complies, then register the student
                    //Just as suggestion to student we'll show some courses
                    String suggestion = "<pre>Just as suggestion please review these prerequisites: <br>";
                    for(Course c: pre){
                        suggestion += c.getName() + "<br>";
                    }
                    suggestion += "<pre>";
                    message =  suggestion;
                }
            }
        }
        return message;
    }

    public List<SectionHelp> dataForStudentList(){
        String username;
        Long stuId;

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            username = ((UserDetails) principal).getUsername();
        } else {
            username = principal.toString();
        }
        Student sesStu = studentService.findStudentByEmail(username);
        stuId = sesStu.getId();
        List<Section> sectionRec = sesStu.getSections();
        List<SectionHelp> sectionStudentData = new ArrayList<>();

        for (Section section: sectionRec) {
            SectionHelp shelper = new SectionHelp();
            shelper.setSection(section);
            long facultyId = section.getFacultyId();
            Faculty faculty = facultyService.findById(facultyId);
            shelper.setFaculty(faculty);
            long blockId = section.getBlockId();
            Block block = blockService.findById(blockId);
            shelper.setBlock(block);
            long courseId = section.getCourseId();
            Course course = courseService.findById(courseId);
            shelper.setCourse(course);
            List<Student> studentl = section.getStudent();
            for(Student student: studentl){shelper.addStudent(student);}
            sectionStudentData.add((shelper));
        }
        return sectionStudentData;
    }
}
