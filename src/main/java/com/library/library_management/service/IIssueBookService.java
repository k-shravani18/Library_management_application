package com.library.library_management.service;

import com.library.library_management.model.IssueBook;
import java.util.List;

public interface IIssueBookService {
    public void issueBook(IssueBook issueBook, Long memberId);
    public IssueBook updateIssueBook(IssueBook issueBook);
    String deleteIssueBook(IssueBook  issueBook);
    public IssueBook getById(Long id);
    List<IssueBook>getAll();

}