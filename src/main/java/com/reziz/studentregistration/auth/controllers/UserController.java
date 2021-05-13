package com.reziz.studentregistration.auth.controllers;

import com.reziz.studentregistration.auth.models.User;
import com.reziz.studentregistration.auth.models.dto.UserCreateRequest;
import com.reziz.studentregistration.auth.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.security.Principal;
import java.util.Optional;

@Controller
@RequestMapping("/account")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping
    public String index(Model model) {
        model.addAttribute("accounts", userService.findAll());
        return "auth/index";
    }

    @GetMapping("/add")
    public String add(@ModelAttribute("account") UserCreateRequest account) {
        return "auth/form";
    }

    @PostMapping
    public String save(@Valid @ModelAttribute("account") UserCreateRequest account, BindingResult result, RedirectAttributes ra) {
        if (result.hasErrors()) {
            return "auth/form";
        }
        var user = userService.createUser(account);
        ra.addFlashAttribute("account", user);
        ra.addAttribute("id", user.getId())
                .addFlashAttribute("message", "Account created!");
        return "redirect:/account/{id}";
    }

    @GetMapping(value = "/profile")
    public String profile(Model model, Principal principal) {
        Optional<User> currentUser = userService.findByUsername(principal.getName());
        model.addAttribute("currentUser", currentUser.get());
        return "auth/profile";
    }

    @GetMapping("/{id}")
    public String get(@PathVariable Long id, Model model) {
        model.addAttribute("currentUser", userService.findById(id));
        return "auth/profile";
    }

}
