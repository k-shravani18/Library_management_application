package com.library.library_management.controller;

import com.library.library_management.model.*;
import com.library.library_management.service.impl.BookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/webc")
public class NewController {
    @Autowired
    private BookServiceImpl bookService;

    // Display the login form
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

    // Display the admin form
    @GetMapping("/dashboard")
    public ModelAndView showAdminForm() {
        return new ModelAndView("dashboard");
    }

    //category
    // Display the category form
//    @GetMapping("/category")
//    public String showCategoryForm(Model model) {
//        model.addAttribute("bookProfile", new BookProfile());
//        return "categoryForm";
//    }
    @GetMapping("/author")
    public String showAuthorForm(Model model) {
        model.addAttribute("author", new Author());
        return "authorForm";
    }

    @GetMapping("/publisher")
    public String showPublisherForm(Model model) {
        model.addAttribute("publisher", new Publisher());
        return "publisherForm";
    }
    @GetMapping("/book")
    public String showAddBookForm(Model model) {
        model.addAttribute("book", new Book());
        return "book";
    }

    @GetMapping("/member")
    public String showRegistrationForm(Model model) {
        model.addAttribute("member", new Member());
        model.addAttribute("address",new Address());
        return "memberForm";
    }
    @GetMapping("/issueBook")
    public String showIssueBookForm(Model model) {
        // Add necessary data to the model if required
        return "issueBook";
    }

    @GetMapping("/returnbook")
    public String showReturnBookForm(Model model) {
        // Add necessary data to the model if required
        return "returnBook";
    }

    // Handle the category form submission
    //@PostMapping(value = "/category/add")
//    @RequestMapping(value = "/category/add",method = RequestMethod.POST)
//    public String addCategory(@ModelAttribute("bookProfile") BookProfile bookProfile) {
//        // Save the bookProfile to the database
//        bookService.saveBookProfile(bookProfile);
//        return "redirect:/webc/dashboard";
//    }


//    @GetMapping("/details/{bookId}")
//    public String showBookDetails(@PathVariable("bookId") Long bookId, Model model) {
//        Book book = bookService.getById(bookId);
//        if (book == null) {
//            return "error-page"; // or any other appropriate view
//        }
//        model.addAttribute("book", book);
//        return "book-list";
//    }















    @GetMapping("/{file-name}")
    public String categoryPage(@PathVariable("file-name") String filename) {
        // Logic for Category page
        return filename;
    }
}
