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

import com.jawaher.mum.domain.Section;
import com.jawaher.mum.service.SectionService;


@Controller
public class SectionController {
	
	@Autowired
    SectionService sectionService;
	
	
	
	@RequestMapping(value="/section/{id}", method = RequestMethod.GET)
	public String view(@PathVariable Long id, Model model){	
		model.addAttribute("section", sectionService.getById(id));
		return "section/edit";
	}
	
	@RequestMapping(value="/section/delete/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable Long id, Model model){		
		sectionService.remove(sectionService.getById(id));
		return "redirect:/sections";
	}	
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index( Model model){
        return "index";
    }

    @RequestMapping(value = "/sectionregform", method = RequestMethod.GET)
    public String sectionRegForm( Model model){
        //instantiate an employee object
        Section  section = new Section();
        model.addAttribute("newsection" , section);
        return "sectionregform";
    }
    @RequestMapping(value = {"/addnewsection"}, method = RequestMethod.POST)
    public String registersection(@Valid @ModelAttribute("newsection") Section section, BindingResult bindingResult, Model model){

        if (bindingResult.hasErrors()) {
            return "sectionregform";
        }

        Section s=  sectionService.save(section);

        model.addAttribute(s);
        return "addsuccess";
    }

    @GetMapping("/sectionlist")
    public String getAllsection(Model model) {
        List<Section> sections = sectionService.findAll();
        model.addAttribute("sections",  sections);
        return "listsection";
    }

}
