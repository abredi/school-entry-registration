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

import com.jawaher.mum.domain.Schedule;

import com.jawaher.mum.service.ScheduleService;


@Controller
public class ScheduleController {
	
	@Autowired
    ScheduleService scheduleService;
	
	
	
	@RequestMapping(value="/schedule/{id}", method = RequestMethod.GET)
	public String view(@PathVariable Long id, Model model){	
		model.addAttribute("schedule", scheduleService.getById(id));
		return "schedule/edit";
	}
	
	@RequestMapping(value="/schedule/delete/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable Long id, Model model){		
		scheduleService.remove(scheduleService.getById(id));
		return "redirect:/schedules";
	}	
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index( Model model){
        return "index";
    }

    @RequestMapping(value = "/scheduleregform", method = RequestMethod.GET)
    public String scheduleRegForm( Model model){
        //instantiate an employee object
        Schedule  schedule = new Schedule();
        model.addAttribute("newschedule" , schedule);
        return "scheduleregform";
    }
    @RequestMapping(value = {"/addnewschedule"}, method = RequestMethod.POST)
    public String registerschedule(@Valid @ModelAttribute("newschedule") Schedule schedule, BindingResult bindingResult, Model model){

        if (bindingResult.hasErrors()) {
            return "scheduleregform";
        }
        //schedule SAVE IN PERSISTENCE
        Schedule s=  scheduleService.save(schedule);

        //GET schedule FROM PERSISTENCE
        model.addAttribute(s);
        return "addsuccess";
    }

    @GetMapping("/schedulelist")
    public String getAllschedule(Model model) {
        List<Schedule> schedules = scheduleService.findAll();
        model.addAttribute("schedules",  schedules);
        return "listschedule";
    }

}
