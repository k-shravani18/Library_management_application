package com.library.library_management.controller;

import com.library.library_management.exceptions.AuthorNotFoundException;
import com.library.library_management.exceptions.CategoryNotFoundException;
import com.library.library_management.model.Author;
import com.library.library_management.model.Category;
import com.library.library_management.service.IAuthorService;
import com.library.library_management.service.impl.AuthorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/author")
public class AuthorController {
    @Autowired
    private AuthorServiceImpl authorService;

    @GetMapping("/author_form")
    public String showAuthorForm(Model model) {
        model.addAttribute("author", new Author());
        return "createAuthorForm";
    }

    @PostMapping(value = "/add_author")
    public String addAuthor(@ModelAttribute("author") Author author) {
        authorService.addAuthor(author);
        return "redirect:/author/success";
    }

    @GetMapping("/success")
    public String showSuccessPage() {
        return "successForm";
    }

    @GetMapping("/editAuthor")
    public String showEditForm(@RequestParam("authorId") Long authorId, Model model) {
        try {
            Author author = authorService.getById(authorId);
            if (author == null) {
                throw new AuthorNotFoundException("author not found with ID: " + authorId);
            }

            model.addAttribute("author", author);

            return "editAuthorForm";
        } catch (AuthorNotFoundException e) {
            return handlingAuthorNotFoundException(model);
        }
    }

    @PutMapping("/updateAuthor")
    public String updateAuthor(@ModelAttribute("author") Author author,
                                 Model model) {
        author.setAuthorName(author.getAuthorName().toUpperCase());
        authorService.updateAuthor(author);

        return "redirect:/author/editSuccess";
    }

    @GetMapping("/editSuccess")
    public String updationSuccess(Model model) {
        String successMessage = "Author Updated Successfully";
        model.addAttribute("successMessage", successMessage);
        return "globalSuccessForm";
    }


    @GetMapping("/delete")
    public String showDeleteForm(@RequestParam("authorId") Long authorId, Model model) {
        try {
            Author author = authorService.getById(authorId);
            if (author == null) {
                throw new AuthorNotFoundException("Author not found with ID: " + authorId);
            }

            model.addAttribute("author", author);

            return "deleteAuthorForm";
        } catch (AuthorNotFoundException e) {
            return handlingAuthorNotFoundException(model);
        }
    }


    @DeleteMapping("/deleteAuthor")
    public String deleteAuthor(@ModelAttribute("author") Author author,
                                 Model model) {

        authorService.deleteAuthor(author);

        return "redirect:/author/deleteSuccess";
    }

    @GetMapping("/deleteSuccess")
    public String deleteSuccess(Model model) {
        String successMessage = "Author Deleted Successfully";
        model.addAttribute("successMessage", successMessage);
        return "globalSuccessForm";
    }

    @GetMapping("/allAuthors")
    public String getAllAuthors(Model model) {
        List<Author> authors = authorService.getAll();
        model.addAttribute("authors", authors);
        return "getAuthors";
    }

    @ExceptionHandler
    private String handlingAuthorNotFoundException(Model model) {
        model.addAttribute("", "AuthorNotFoundException");
        return "authorNotFoundException";
    }
}