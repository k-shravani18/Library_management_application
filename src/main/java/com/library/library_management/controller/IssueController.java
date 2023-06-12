package com.library.library_management.controller;

import com.library.library_management.exceptions.MemberNotFoundException;
import com.library.library_management.model.IssueBook;
import com.library.library_management.service.IIssueBookService;
import com.library.library_management.service.impl.IssueBookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Controller
@RequestMapping("/issue")
public class IssueController {

    private IssueBookServiceImpl issueBookService;

    @Autowired
    public IssueController(IssueBookServiceImpl issueBookService) {
        this.issueBookService = issueBookService;
    }
    @GetMapping("/add")
    public String showIssueBookForm(Model model) {
        model.addAttribute("issueBook", new IssueBook());
        model.addAttribute("memberId", "");
        return "issueBook";
    }

    @PostMapping("/addForm")
    public String issueBook(@ModelAttribute("issueBook") IssueBook issueBook,
                            @RequestParam("memberId") Long memberId, Model model) {
        try {
            issueBookService.issueBook(issueBook, memberId);
            return "redirect:/issue/success";
        } catch (MemberNotFoundException e) {
            // Handle the MemberNotFoundException
            return handleMemberNotFoundException(model); // Provide the appropriate error page or view name
        }
    }


    @GetMapping("/success")
    public String issueBookSuccess() {
        return "issueBookSuccess";
    }

    @ExceptionHandler(NumberFormatException.class)
    public String handleMemberNotFoundException(Model model) {
        model.addAttribute("", "MemberNotFoundException");
        return "memberNotFoundError";
    }
//    @Override
//    public String updateIssueBook(IssueBook issueBook) {
//        issueBookService.updateIssueBook(issueBook);
//        return null;
//    }
//
//    @Override
//    public String deleteIssueBook(IssueBook issueBook) {
//        issueBookService.deleteIssueBook(issueBook);
//        return null;
//    }
//
//    @Override
//    public IssueBook getById(Long issue_book_id) {
//        return issueBookService.getById(issue_book_id);
//    }
//
//    @Override
//    public List<IssueBook> getAll() {
//        return null;
//    }
}
