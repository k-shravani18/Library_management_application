package com.library.library_management.controller;

import com.library.library_management.model.*;
import com.library.library_management.service.impl.AuthorServiceImpl;
import com.library.library_management.service.impl.BookServiceImpl;
import com.library.library_management.service.impl.CategoryServiceImpl;
import com.library.library_management.service.impl.PublisherServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/webc")
public class MainController {
    @Autowired
    private BookServiceImpl bookService;
    @Autowired
    private CategoryServiceImpl categoryService;
    @Autowired
    private AuthorServiceImpl authorService;
    @Autowired
    private PublisherServiceImpl publisherService;

    @GetMapping("/login")
    public String showLoginForm(Model model) {
        model.addAttribute("loginForm", new User());
        return "loginForm";
    }

    @PostMapping("/processLogin")
    public ModelAndView processLoginForm(@ModelAttribute("loginForm") User user) {
        if (user.getUsername().equals("shravani") && user.getPassword().equals("shravani123")) {
            return new ModelAndView("redirect:/webc/dashboard");
        } else {
            ModelAndView modelAndView = new ModelAndView("loginForm");
            modelAndView.addObject("loginForm", user);
            modelAndView.addObject("error", "Invalid username or password");
            return modelAndView;
        }
    }

    // Display the admin form
    @GetMapping("/dashboard")
    public ModelAndView showAdminForm() {
        return new ModelAndView("dashboard");
    }

    @GetMapping("/book")
    public String showAddBookForm(Model model) {
        model.addAttribute("book", new Book());
        return "book";
    }

    @GetMapping("/member")
    public String showRegistrationForm(Model model) {
        model.addAttribute("member", new Member());
        model.addAttribute("address", new Address());
        return "memberForm";
    }

    @GetMapping("/issueBook")
    public String showIssueBookForm(Model model) {
        return "issueBook";
    }

    @GetMapping("/returnbook")
    public String showReturnBookForm(Model model) {
        return "returnBook";
    }
























    @GetMapping("/{file-name}")
    public String categoryPage(@PathVariable("file-name") String filename) {
        // Logic for Category page
        return filename;
    }
}
