package com.library.library_management.controller;

import com.library.library_management.model.Book;
import com.library.library_management.service.IBookService;
import com.library.library_management.service.impl.BookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/book")
public class BookController {
    @Autowired
    private BookServiceImpl bookService;

    public Book addBook(Book book) {
        return bookService.addBook(book);
    }

    public String updateBook(Book book) {
        bookService.updateBook(book);
        return null;
    }
    public String deleteBook(Book book) {
        bookService.deleteBook(book);
        return null;
    }

    public Book getById(Long bookId) {
        return bookService.getBookById(bookId);
    }

    public List<Book> getAll() {
        return null;
    }
}
