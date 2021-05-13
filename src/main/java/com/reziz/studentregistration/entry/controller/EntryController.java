package com.reziz.studentregistration.entry.controller;

import com.reziz.studentregistration.entry.domain.Entry;
import com.reziz.studentregistration.entry.domain.EntryDTO;
import com.reziz.studentregistration.entry.service.EntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/entry")
public class EntryController {

    @Autowired
    private EntryService entryService;

    @GetMapping({"index", "/", ""})
    public String index(Model model) {
        model.addAttribute("entryList", entryService.getAllEntry());
        return "entry/index";
    }

    @GetMapping("/add")
    public String add(@ModelAttribute("entry") EntryDTO entry) {
        return "entry/form";
    }

    @PostMapping("/add")
    public String save(@Valid @ModelAttribute("entry") EntryDTO entry, BindingResult result, RedirectAttributes ra) {
        if (result.hasErrors()) {
            return "entry/form";
        }
        var persistEntry = new Entry();
        persistEntry.setEntryName(entry.getEntryName());
        persistEntry.setEndDate(entry.getEndDate());
        persistEntry.setStartDate(entry.getStartDate());
        persistEntry.setFPPNum(entry.getFPPNum());
        persistEntry.setMPPNum(entry.getMPPNum());
        ra.addFlashAttribute("entry",  entryService.save(persistEntry));
        ra.addAttribute("id", entryService.save(persistEntry).getId()).addFlashAttribute("message", "Course created!");
        return "redirect:/entry/{id}";
    }

    @GetMapping("/detail")
    public String detail(){
        return "entry/detail";
    }

    @GetMapping("/{id}")
    public String get(@PathVariable Long id, Model model) {
        model.addAttribute("entry", entryService.findById(id));
        return "entry/detail";
    }
}
