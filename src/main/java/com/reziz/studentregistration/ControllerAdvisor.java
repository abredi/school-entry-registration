package com.reziz.studentregistration;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;

@ControllerAdvice
public class ControllerAdvisor {
    @ModelAttribute
    public void all(Model model, Principal principal) {
        model.addAttribute("user", principal);
    }

    @ExceptionHandler(Exception.class)
    public ModelAndView myError(Exception exception) {
        ModelAndView mav = new ModelAndView();
        mav.addObject("exception", exception);
        mav.setViewName("error");
        return mav;
    }
}
