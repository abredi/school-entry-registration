package com.jawaher.mum.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jawaher.mum.domain.Course;
import com.jawaher.mum.service.CourseService;


@Controller
public class CourseController {
	
	
	@Autowired
   CourseService courseService;
	
	
	
	@RequestMapping(value="/course/{id}", method = RequestMethod.GET)
	public String view(@PathVariable Long id, Model model){	
		model.addAttribute("course", courseService.getById(id));
		return "course/edit";
	}
	
	@RequestMapping(value="/course/delete/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable Long id, Model model){		
		courseService.remove(courseService.getById(id));
		return "redirect:/courses";
	}	
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index( Model model){
        return "index";
    }

    @RequestMapping(value = "/courseregform", method = RequestMethod.GET)
    public String courseRegForm( Model model){
        //instantiate an employee object
        Course  course = new Course();
        model.addAttribute("newcourse" , course);
        return "courseregform";
    }
    @RequestMapping(value = {"/addnewcourse"}, method = RequestMethod.POST)
    public String registercourse(@Valid @ModelAttribute("newcourse") Course course, BindingResult bindingResult, Model model){

        if (bindingResult.hasErrors()) {
            return "courseregform";
        }
        //course SAVE IN PERSISTENCE
        Course s=  courseService.save(course);

        //GET course FROM PERSISTENCE
        model.addAttribute(s);
        return "addsuccess";
    }

    @GetMapping("/courselist")
    public String getAllcourse(Model model) {
        List<Course > courses = courseService.findAll();
        model.addAttribute("courses",  courses);
        return "listcourse";
    }

}
