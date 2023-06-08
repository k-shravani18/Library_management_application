package com.library.library_management.service.impl;

import com.library.library_management.model.Author;
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
        return null;
    }

    @Override
    public String deleteAuthor(Author author) {
        return null;
    }

    @Override
    public Author getById(Long author_id) {
        return null;
    }

    @Override
    public List<Author> getAll() {
        return null;
    }
}
