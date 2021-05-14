package com.reziz.studentregistration.profile.controller;

import com.reziz.studentregistration.auth.models.UserAuthDetails;
import com.reziz.studentregistration.auth.services.UserService;
import com.reziz.studentregistration.profile.domain.ProfileDTO;
import com.reziz.studentregistration.profile.service.ProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.security.Principal;

@RequiredArgsConstructor
@Controller
@RequestMapping("/profile")
public class ProfileController {
    private final ProfileService profileService;
    private final UserService userService;

    @GetMapping
    public String index(Model model, Principal p) {
        var cUser = (UserAuthDetails) ((UsernamePasswordAuthenticationToken) p).getPrincipal();
        var currentUser = userService.findByUsername(cUser.getUsername());
        cUser.getAuthorities().forEach(s -> System.out.println(s));
        var currentProfile = cUser.getAuthorities()
                .contains(new SimpleGrantedAuthority("faculty"))
                ? profileService.findByUsername(cUser.getUsername()) : null;
        model.addAttribute("currentUser", currentUser);
        model.addAttribute("profile", currentProfile);
        return "profile/detail";
    }

    @GetMapping("/add")
    public String add(@ModelAttribute("profile") ProfileDTO profile) {
        return "profile/form";
    }

    @PostMapping
    public String save(@Valid @ModelAttribute("profile") ProfileDTO profileDTO, BindingResult result, RedirectAttributes ra, Principal p) {
        if (result.hasErrors()) {
            return "profile/form";
        }
        var cUser = (UserAuthDetails) ((UsernamePasswordAuthenticationToken) p).getPrincipal();
        profileDTO.setUsername(cUser.getUsername());
        var profile = profileService.save(profileDTO);
        ra.addFlashAttribute("profile", profile);
        ra.addFlashAttribute("message", "Profile created!");
        return "redirect:/profile";
    }

    @GetMapping("/{id}")
    public String get(@PathVariable Long id, Model model) {
        model.addAttribute("profile", profileService.findById(id));
        return "profile/detail";
    }
}
