package com.library.library_management.controller;

import com.library.library_management.exceptions.BookNotFoundException;
import com.library.library_management.model.Book;
import com.library.library_management.service.IBookService;
import com.library.library_management.service.impl.BookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/book")
public class BookController {
    @Autowired
    private BookServiceImpl bookService;

    @GetMapping("/add")
    public String showAddBookForm(Model model) {
        model.addAttribute("book", new Book());
        return "createBookForm";
    }

    @PostMapping("/addBook")
    public String addBook(@ModelAttribute("book") Book book, Model model) {
        System.out.println(book.getAuthor());
        bookService.addBook(book);
        return "redirect:/book/createSuccess";
    }


    @GetMapping("/createSuccess")
    public String showSuccessPage(Model model) {
        String successMessage = "Book Added Successfully";
        model.addAttribute("successMessage", successMessage);
        return "successForm";
    }

    @GetMapping("/editBook")
    public String showEditForm(@RequestParam("bookId") Long bookId, Model model) {
        try {
            Book book = bookService.getBookById(bookId);
            if (book == null) {
                throw new BookNotFoundException("Book not found with ID: " + bookId);
            }

            model.addAttribute("book", book);

            return "editBookForm";
        } catch (BookNotFoundException e) {
            return handlingBookNotFoundException(model);
        }
    }


    @PutMapping("/updateBook")
    public String updateBook(@ModelAttribute("book") Book book,
                             Model model) {
        bookService.updateBook(book);

        return "redirect:/book/editSuccess";
    }

    @GetMapping("/editSuccess")
    public String updationSuccess(Model model) {
        String successMessage = "Book Updated Successfully";
        model.addAttribute("successMessage", successMessage);
        return "globalSuccessForm";
    }

    @GetMapping("/delete")
    public String showDeleteForm(@RequestParam("bookId") Long bookId, Model model) {
        try {
            Book book = bookService.getBookById(bookId);
            if (book == null) {
                throw new BookNotFoundException("Book not found with ID: " + bookId);
            }

            model.addAttribute("book", book);

            return "deleteBookForm";
        } catch (BookNotFoundException e) {
            return handlingBookNotFoundException(model);
        }
    }


    @DeleteMapping("/deleteBook")
    public String deleteBook(@ModelAttribute("book") Book book,
                             Model model) {

        bookService.deleteBook(book);

        return "redirect:/book/deleteSuccess";
    }

    @GetMapping("/deleteSuccess")
    public String deleteSuccess(Model model) {
        String successMessage = "Book Deleted Successfully";
        model.addAttribute("successMessage", successMessage);
        return "globalSuccessForm";
    }

    @GetMapping("/allBooks")
    public String getAllBooks(Model model) {
        List<Book> books = bookService.getAllBook();
        model.addAttribute("books", books);
        return "getBooks";
    }

    @ExceptionHandler(BookNotFoundException.class)
    private String handlingBookNotFoundException(Model model) {
        String message = "Book Not Found For The Given Book ID";
        model.addAttribute("message", message);
        return "globalSuccessForm";
    }
}