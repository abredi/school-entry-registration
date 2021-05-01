package com.reziz.studentregistration.block.controller;

import com.reziz.studentregistration.block.domain.Block;
import com.reziz.studentregistration.block.domain.BlockDTO;
import com.reziz.studentregistration.block.service.BlockService;
import com.reziz.studentregistration.entry.domain.Entry;
import com.reziz.studentregistration.entry.service.EntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/block")
public class BlockController {

    @Autowired
    private BlockService blockService;
    @Autowired
    private EntryService entryService;

    @GetMapping({"index", "/", ""})
    public String index(Model model) {
        model.addAttribute("blockList", blockService.getAllBlock());
        return "block/index";
    }

    @GetMapping("/add")
    public String add(@ModelAttribute("block") BlockDTO block, Model model) {
        model.addAttribute("entries", entryService.getAllEntry());
        return "block/form";
    }

    @PostMapping("/add")
    public String save(@Valid @ModelAttribute("block") BlockDTO block, BindingResult result, RedirectAttributes ra) {
        if (result.hasErrors()) {
            return "block/form";
        }
        var persistBlock = new Block();
        var entry = entryService.getEntryByEntryID(block.getEntry());
        persistBlock.setEntry(entry);
        persistBlock.setEndDate(block.getEndDate());
        persistBlock.setStartDate(block.getStartDate());
        persistBlock.setFPPNum(block.getFPPNum());
        persistBlock.setMPPNum(block.getMPPNum());
        persistBlock.setBlockName(block.getBlockName());
        ra.addFlashAttribute("block",  blockService.save(persistBlock));
        ra.addAttribute("id", blockService.save(persistBlock).getId()).addFlashAttribute("message", "Block created!");
        return "redirect:/block/{id}";
    }

    @GetMapping("/detail")
    public String detail(){
        return "block/detail";
    }

    @GetMapping("/{id}")
    public String get(@PathVariable Long id, Model model) {
        model.addAttribute("block", blockService.findById(id));
        return "block/detail";
    }
}
