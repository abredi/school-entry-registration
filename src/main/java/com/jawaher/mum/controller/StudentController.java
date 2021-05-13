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

import com.jawaher.mum.domain.Student;
import com.jawaher.mum.service.StudentService;


@Controller
public class StudentController {
	
	
	
	@Autowired
    StudentService studentService;
	
	
	
	@RequestMapping(value="/student/{id}", method = RequestMethod.GET)
	public String view(@PathVariable Long id, Model model){	
		model.addAttribute("student", studentService.getById(id));
		return "student/edit";
	}
	
	@RequestMapping(value="/student/delete/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable Long id, Model model){		
		studentService.remove(studentService.getById(id));
		return "redirect:/students";
	}	
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index( Model model){
        return "index";
    }

    @RequestMapping(value = "/studentregform", method = RequestMethod.GET)
    public String studentRegForm( Model model){
        //instantiate an employee object
        Student  student = new Student();
        model.addAttribute("newStudent" , student);
        return "studentregform";
    }
    @RequestMapping(value = {"/addnewstudent"}, method = RequestMethod.POST)
    public String registerStudent(@Valid @ModelAttribute("newStudent") Student student, BindingResult bindingResult, Model model){

        if (bindingResult.hasErrors()) {
            return "studentregform";
        }
        //STUDENT SAVE IN PERSISTENCE
        Student s=  studentService.save(student);

        //GET STUDENT FROM PERSISTENCE
        model.addAttribute(s);
        return "addsuccess";
    }

    @GetMapping("/studentlist")
    public String getAllStudent(Model model) {
        List<Student> students = studentService.findAll();
        model.addAttribute("students",  students);
        return "listStudent";
    }
    
    

}
