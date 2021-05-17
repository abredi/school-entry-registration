package com.reziz.studentregistration.student.controller;

import com.reziz.studentregistration.student.domain.Student;
import com.reziz.studentregistration.student.domain.StudentDTO;
import com.reziz.studentregistration.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping({"index", "/", ""})
    public String index(Model model) {
        model.addAttribute("studentList", studentService.getAllStudents());
        return "student/index";
    }

    @GetMapping("/add")
    public String add(@ModelAttribute("student") StudentDTO student) {
        return "student/form";
    }

    @PostMapping("/add")
    public String save(@Valid @ModelAttribute("student") StudentDTO student, BindingResult result, RedirectAttributes ra) {
        if (result.hasErrors()) {
            return "student/form";
        }
        var persistStudent = new Student();
        persistStudent.setFirstName(student.getFirstName());
        persistStudent.setLastName(student.getLastName());
        persistStudent.setEmail(student.getEmail());
        ra.addFlashAttribute("student",  studentService.save(persistStudent));
        ra.addAttribute("id", studentService.save(persistStudent).getId()).addFlashAttribute("message", "Student created!");
        return "redirect:/student/{id}";
    }

    @GetMapping("/detail")
    public String detail(){
        return "student/detail";
    }

    @GetMapping("/{id}")
    public String get(@PathVariable Long id, Model model) {
        model.addAttribute("student", studentService.findById(id));
        return "student/detail";
    }
}
