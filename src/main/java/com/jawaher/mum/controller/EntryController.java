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

import com.jawaher.mum.domain.Entry;
import com.jawaher.mum.domain.entry;
import com.jawaher.mum.service.EntryService;


@Controller
public class EntryController {
	
	@Autowired
    EntryService entryService;
	
	
	
	@RequestMapping(value="/entry/{id}", method = RequestMethod.GET)
	public String view(@PathVariable Long id, Model model){	
		model.addAttribute("entry", entryService.getById(id));
		return "entry/edit";
	}
	
	@RequestMapping(value="/entry/delete/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable Long id, Model model){		
		entryService.remove(entryService.getById(id));
		return "redirect:/entrys";
	}	
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index( Model model){
        return "index";
    }

    @RequestMapping(value = "/entryregform", method = RequestMethod.GET)
    public String entryRegForm( Model model){
        //instantiate an employee object
        Entry  entry = new Entry();
        model.addAttribute("newentry" , entry);
        return "entryregform";
    }
    @RequestMapping(value = {"/addnewentry"}, method = RequestMethod.POST)
    public String registerentry(@Valid @ModelAttribute("newentry") Entry entry, BindingResult bindingResult, Model model){

        if (bindingResult.hasErrors()) {
            return "entryregform";
        }
        //entry SAVE IN PERSISTENCE
        Entry s=  entryService.save(entry);

        //GET entry FROM PERSISTENCE
        model.addAttribute(s);
        return "addsuccess";
    }

    @GetMapping("/entrylist")
    public String getAllentry(Model model) {
        List<Entry> entrys = entryService.findAll();
        model.addAttribute("entrys",  entrys);
        return "listentry";
    }

}
