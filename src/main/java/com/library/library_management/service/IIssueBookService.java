package com.library.library_management.service;

import com.library.library_management.model.IssueBook;
import java.util.List;

public interface IIssueBookService {
    public void issueBook(IssueBook issueBook, Long memberId);
    String updateIssueBook(IssueBook issueBook);
    String deleteIssueBook(IssueBook  issueBook);
    IssueBook getById(Long issue_book_id);
    List<IssueBook>getAll();



    //custom operations
//    List<Book> getByName(String name);
//    List<Book> getByNameAndEdition(String name,String edition);
//    List<Book> getByGenre(String genre);
//    List<Book> getByPrice(Double price);
//    List<Book> getByPages(Long pages);
//    List<Book> getByUserId(Long user_id);
}