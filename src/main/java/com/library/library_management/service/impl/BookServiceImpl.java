package com.library.library_management.service.impl;

import com.library.library_management.exceptions.BookNotFoundException;
import com.library.library_management.model.Book;
import com.library.library_management.repository.IBookRepository;
import com.library.library_management.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BookServiceImpl implements IBookService {
    private final IBookRepository bookRepository;

    public BookServiceImpl(IBookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }


    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Book updateBook(Book book) {
        Book existingBook = bookRepository.findById(book.getBookId()).orElse(null);
        if (existingBook == null) {
            return null;
        }

        existingBook.setBookName(book.getBookName());
        existingBook.setEdition(book.getEdition());
        existingBook.setNoOfPages(book.getNoOfPages());
        return bookRepository.save(existingBook);
    }

    @Override
    public void deleteBook(Book book) {

        bookRepository.delete(book);
    }

    @Override
    public Book getBookById(Long bookId) {
        return bookRepository.findById(bookId).orElseThrow(
                () -> new BookNotFoundException("Book Not Found " + bookId)
        );
    }

    @Override
    public List<Book> getAllBook() {
        return bookRepository.findAll();

    }
}