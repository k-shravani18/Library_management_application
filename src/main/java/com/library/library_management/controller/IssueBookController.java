package com.library.library_management.controller;

import com.library.library_management.exceptions.BookNotFoundException;
import com.library.library_management.exceptions.IssueBookNotFoundException;
import com.library.library_management.exceptions.MemberNotFoundException;
import com.library.library_management.model.Book;
import com.library.library_management.model.IssueBook;
import com.library.library_management.model.Member;
import com.library.library_management.service.impl.BookServiceImpl;
import com.library.library_management.service.impl.IssueBookServiceImpl;
import com.library.library_management.service.impl.MemberServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Controller
@RequestMapping("/issue")
public class IssueBookController {

    private final IssueBookServiceImpl issueBookService;
    private final MemberServiceImpl memberService;
    private final BookServiceImpl bookService;

    @Autowired
    public IssueBookController(IssueBookServiceImpl issueBookService, MemberServiceImpl memberService, BookServiceImpl bookService) {
        this.issueBookService = issueBookService;
        this.memberService = memberService;
        this.bookService = bookService;
    }


    @GetMapping("/add")
    public String showIssueBookForm(Model model) {
        model.addAttribute("issueBook", new IssueBook());
        model.addAttribute("memberId", "");
        return "createIssueBookForm";
    }

    @PostMapping("/addForm")
    public String issueBook(@ModelAttribute("issueBook") IssueBook issueBook,
                            @RequestParam("memberId") Long memberId, Model model) {
        try {
            Member member = memberService.getById(memberId);
            Book book = bookService.getBookById(issueBook.getBook().getBookId());
            if (member == null) {
                throw new MemberNotFoundException("Member not found with ID: " + memberId);
            } else if (book == null) {
                throw new BookNotFoundException("Book not found with book id: " + issueBook.getBook().getBookId());
            } else {
                issueBookService.issueBook(issueBook, memberId);
                return "redirect:/issue/issueSuccess";
            }
        } catch (MemberNotFoundException e) {
            return handlingMemberNotFoundException(model, e);
        } catch (BookNotFoundException e) {
            return handlingBookNotFoundException(model, e);
        }
    }
    @GetMapping("/issueSuccess")
    public String issueBookSuccess(Model model) {
        String successMessage = "Book Issued Successfully";
        model.addAttribute("successMessage", successMessage);
        return "globalSuccessForm";
    }

    @GetMapping("/updateIssue")
    public String showUpdateForm(@RequestParam("issueBookId") Long issueBookId, Model model) {
        try{
            IssueBook issueBook = issueBookService.getById(issueBookId);
            if(issueBook == null){
                throw new IssueBookNotFoundException("IssueBook is not found");
            }
            model.addAttribute("issueBook", issueBook);
            return "editIssueBookForm";
        }catch (IssueBookNotFoundException e){
            return handlingIssueBookNotFoundException(model);
        }
    }

    @PutMapping("/updateConfirm")
    public String updateIssueBook(@ModelAttribute("issueBook") IssueBook issueBook,
                                  Model model) {
        issueBookService.updateIssueBook(issueBook);
        return "redirect:/issue/issueSuccessUpdate";
    }
    @GetMapping("issueSuccessUpdate")
    public String updationSuccess(Model model){
        String successMessage = "Issued Book Updated Successfully";
        model.addAttribute("successMessage", successMessage);
        return "globalSuccessForm";
    }

    @GetMapping("/allIssuedBooks")
    public String getAllIssuedBooks(Model model) {
        List<IssueBook> issueBooks = issueBookService.getAll();
        model.addAttribute("issuedBooks", issueBooks);
        return "getIssuedBooks";
    }


    @ExceptionHandler(MemberNotFoundException.class)
    public String handlingMemberNotFoundException(Model model, MemberNotFoundException ex) {
        String message = "Member Not Found For The Given Member ID";
        model.addAttribute("message", message);
        return "globalSuccessForm";
    }

    @ExceptionHandler(BookNotFoundException.class)
    public String handlingBookNotFoundException(Model model, BookNotFoundException ex) {
        String message = "Book Not Found For The Given Book ID";
        model.addAttribute("message", message);
        return "globalSuccessForm";
    }
    @ExceptionHandler(IssueBookNotFoundException.class)
    public String handlingIssueBookNotFoundException(Model model) {
        String message = "Issued Books Not Found For The Given Issue Book ID";
        model.addAttribute("message", message);
        return "globalSuccessForm";
    }

}
