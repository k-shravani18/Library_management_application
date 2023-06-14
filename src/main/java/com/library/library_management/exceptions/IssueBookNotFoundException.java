package com.library.library_management.exceptions;

public class IssueBookNotFoundException extends RuntimeException{
    public IssueBookNotFoundException(String msg){
        super(msg);
    }
}
