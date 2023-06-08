package com.library.library_management.controller;

import com.library.library_management.model.Author;
import com.library.library_management.service.IAuthorService;
import com.library.library_management.service.impl.AuthorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/author")
public class AuthorController {
    @Autowired
    private AuthorServiceImpl authorService;


    public Author addAuthor(Author author) {
        return authorService.addAuthor(author);
    }


    public String updateAuthor(Author author) {
         authorService.addAuthor(author);
         return "added";
    }


    public String deleteAuthor(Author author) {
        authorService.deleteAuthor(author);
        return "deleted";
    }


    public Author getById(Long author_id) {
        return authorService.getById(author_id);
    }


    public List<Author> getAll() {
        return null;
    }
}
