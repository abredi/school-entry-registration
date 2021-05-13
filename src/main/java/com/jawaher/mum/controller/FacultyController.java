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

import com.jawaher.mum.domain.Faculty;
import com.jawaher.mum.domain.faculty;
import com.jawaher.mum.service.FacultyService;


@Controller
public class FacultyController {
	
	@Autowired
    FacultyService facultyService;
	
	
	
	@RequestMapping(value="/faculty/{id}", method = RequestMethod.GET)
	public String view(@PathVariable Long id, Model model){	
		model.addAttribute("faculty", facultyService.getById(id));
		return "faculty/edit";
	}
	
	@RequestMapping(value="/faculty/delete/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable Long id, Model model){		
		facultyService.remove(facultyService.getById(id));
		return "redirect:/facultys";
	}	
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index( Model model){
        return "index";
    }

    @RequestMapping(value = "/facultyregform", method = RequestMethod.GET)
    public String facultyRegForm( Model model){
        //instantiate an employee object
        Faculty  faculty = new Faculty();
        model.addAttribute("newfaculty" , faculty);
        return "facultyregform";
    }
    @RequestMapping(value = {"/addnewfaculty"}, method = RequestMethod.POST)
    public String registerfaculty(@Valid @ModelAttribute("newfaculty") Faculty faculty, BindingResult bindingResult, Model model){

        if (bindingResult.hasErrors()) {
            return "facultyregform";
        }
        //faculty SAVE IN PERSISTENCE
       Faculty s=  facultyService.save(faculty);

        //GET faculty FROM PERSISTENCE
        model.addAttribute(s);
        return "addsuccess";
    }

    @GetMapping("/facultylist")
    public String getAllfaculty(Model model) {
        List<Faculty> facultys = facultyService.findAll();
        model.addAttribute("facultys",  facultys);
        return "listfaculty";
    }

}
