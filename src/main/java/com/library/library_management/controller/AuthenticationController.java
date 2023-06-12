package com.library.library_management.controller;

import com.library.library_management.model.User;
import com.library.library_management.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller()
@RequestMapping("/auth-api")
public class AuthenticationController {

    @Autowired
    private IUserRepository userRepository;

    @GetMapping("/register")
    public String showRegistration(@ModelAttribute("user") User user) {
        return "register";
    }

    @PostMapping(value = "/processRegister")
    public String registerUser(@ModelAttribute("user") User user){
        if(user.getUsername() != null && user.getPassword() != null){
            userRepository.save(user);
        }
        return "redirect:/auth-api/login";
    }
    @GetMapping("/login")
    public String showLoginForm(Model model) {
        model.addAttribute("loginForm", new User());
        return "loginForm";
    }

    // Handle the login form submission
    @PostMapping("/processLogin")
    public ModelAndView processLoginForm(@ModelAttribute("loginForm") User user) {
        // Check if username and password are correct (implement your own logic)
        if (user.getUsername().equals("shravani") && user.getPassword().equals("shravani123")) {
            // If correct, redirect to the admin form
            return new ModelAndView("redirect:/webc/dashboard");
        } else {
            // If incorrect, show the login form again with an error message
            ModelAndView modelAndView = new ModelAndView("loginForm");
            modelAndView.addObject("loginForm", user);
            modelAndView.addObject("error", "Invalid username or password");
            return modelAndView;
        }
    }



}
