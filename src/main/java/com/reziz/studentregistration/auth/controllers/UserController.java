package com.reziz.studentregistration.auth.controllers;

import com.reziz.studentregistration.auth.models.User;
import com.reziz.studentregistration.auth.models.UserAuthDetails;
import com.reziz.studentregistration.auth.models.dto.UserCreateRequest;
import com.reziz.studentregistration.auth.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
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

    @GetMapping("/edit")
    public String edit(@ModelAttribute("account") UserCreateRequest account, Model model, Principal p) throws Exception {
        UserAuthDetails ud = (UserAuthDetails) ((UsernamePasswordAuthenticationToken) p).getPrincipal();
        var user = userService.findByUsername(ud.getUsername());
        account.setFirstName(user.getFirstName());
        account.setLastName(user.getLastName());
        account.setUsername(user.getUsername());
        return "auth/edit";
    }

    @PostMapping("/update")
    public String updatePass(@ModelAttribute("account") UserCreateRequest account, BindingResult result, RedirectAttributes ra, Principal p) {
        var ud = (UserAuthDetails) ((UsernamePasswordAuthenticationToken) p).getPrincipal();
        var user = userService.findByUsername(ud.getUsername());
        if (userService.updateUserPass(user, account) == null) {
            ra.addFlashAttribute("message", "Invalid request");
            return "redirect:/account/edit";
        }
        ra.addAttribute("id", user.getId())
                .addFlashAttribute("message", "Account Updated!");
        return "redirect:/account/{id}";
    }

    @GetMapping(value = "/profile")
    public String profile(Model model, Principal principal) {
        var currentUser = userService.findByUsername(principal.getName());
        model.addAttribute("currentUser", currentUser);
        return "auth/profile";
    }

    @GetMapping("/{id}")
    public String get(@PathVariable Long id, Model model) {
        model.addAttribute("currentUser", userService.findById(id));
        return "auth/profile";
    }

}
