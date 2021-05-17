package com.reziz.studentregistration.course.controller;

import com.reziz.studentregistration.course.domain.CourseDTO;
import com.reziz.studentregistration.course.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping
    public String index(Model model) {
        model.addAttribute("courses", courseService.getAllCourses());
        return "course/index";
    }

    @GetMapping("/add")
    public String add(@ModelAttribute("course") CourseDTO course, Model model) {
        model.addAttribute("courses", courseService.getAllCourses());
        return "course/form";
    }

    @PostMapping
    public String save(@Valid @ModelAttribute("course") CourseDTO course, BindingResult result, RedirectAttributes ra) {
        if (result.hasErrors()) {
            return "course/form";
        }
        var saved = courseService.save(course);
        ra.addFlashAttribute("course", saved);
        ra.addAttribute("id", saved.getId()).addFlashAttribute("message", "Course created!");
        return "redirect:/course/{id}";
    }

    @GetMapping("/{id}")
    public String get(@PathVariable Long id, Model model) {
        model.addAttribute("course", courseService.findById(id));
        return "course/detail";
    }
}
