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

import com.jawaher.mum.domain.Block;

import com.jawaher.mum.service.BlockService;



@Controller
public class BlockController {
	
	@Autowired
    BlockService blockService;
	
	
	
	@RequestMapping(value="/block/{id}", method = RequestMethod.GET)
	public String view(@PathVariable Long id, Model model){	
		model.addAttribute("block", blockService.getById(id));
		return "block/edit";
	}
	
	@RequestMapping(value="/block/delete/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable Long id, Model model){		
		blockService.remove(blockService.getById(id));
		return "redirect:/blocks";
	}	
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index( Model model){
        return "index";
    }

    @RequestMapping(value = "/blockregform", method = RequestMethod.GET)
    public String blockRegForm( Model model){
        //instantiate an employee object
        Block  block = new Block();
        model.addAttribute("newblock" , block);
        return "blockregform";
    }
    @RequestMapping(value = {"/addnewblock"}, method = RequestMethod.POST)
    public String registerblock(@Valid @ModelAttribute("newblock") Block block, BindingResult bindingResult, Model model){

        if (bindingResult.hasErrors()) {
            return "blockregform";
        }
        //block SAVE IN PERSISTENCE
        Block s=  blockService.save(block);

        //GET block FROM PERSISTENCE
        model.addAttribute(s);
        return "addsuccess";
    }

    @GetMapping("/blocklist")
    public String getAllblock(Model model) {
        List<Block> blocks = blockService.findAll();
        model.addAttribute("blocks",  blocks);
        return "listblock";
    }

}
