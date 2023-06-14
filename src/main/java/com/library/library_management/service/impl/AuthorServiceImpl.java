package com.library.library_management.service.impl;

import com.library.library_management.exceptions.AuthorNotFoundException;
import com.library.library_management.model.Author;
import com.library.library_management.model.Category;
import com.library.library_management.repository.IAuthorRepository;
import com.library.library_management.service.IAuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImpl implements IAuthorService {
    @Autowired
    private IAuthorRepository authorRepository;

    @Override
    public Author addAuthor(Author author) {
        return authorRepository.save(author);
    }

    @Override
    public String updateAuthor(Author author) {
        Author existingAuthor = authorRepository.findById(author.getAuthorId()).orElse(null);
        if (existingAuthor == null) {
            return null;
        }
        existingAuthor.setAuthorName(author.getAuthorName());
        existingAuthor.setCountry(author.getCountry());
        authorRepository.save(existingAuthor);
        return "added";
    }

    @Override
    public String deleteAuthor(Author author) {
        Author existingAuthor = authorRepository.findById(author.getAuthorId()).orElse(null);
         if (existingAuthor == null) {
             new AuthorNotFoundException("Author not found");
        }
        else {
            authorRepository.delete(existingAuthor);
        }
        return "deleted";
    }

    @Override
    public Author getById(Long author_id) {
        return authorRepository.findById(author_id).orElseThrow(
                ()-> new AuthorNotFoundException("Author not found "+author_id)
        );
    }

    @Override
    public List<Author> getAll() {
        return authorRepository.findAll();
    }
}
