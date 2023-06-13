package com.library.library_management.controller;

import com.library.library_management.model.User;
import com.library.library_management.repository.IUserRepository;
import com.library.library_management.service.impl.AuthServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.Base64Utils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.nio.charset.StandardCharsets;

@Controller()
@RequestMapping("/auth-api")
public class AuthenticationController {

    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private AuthServiceImpl authService;

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
    public ModelAndView processLoginForm(@ModelAttribute("loginForm") User user, HttpServletRequest request) {
        // Check if username and password are correct (implement your own logic)
        User validUser = authService.findByUnameAndPass(user.getUsername(), user.getPassword());
        if (validUser != null) {
            String sourceCode = user.getUsername()+":"+user.getPassword();
            String encode = "Basic "+ Base64Utils.encodeToString(sourceCode.getBytes(StandardCharsets.UTF_8));
            HttpSession session = request.getSession();
            session.setAttribute("auth-token", encode);
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
