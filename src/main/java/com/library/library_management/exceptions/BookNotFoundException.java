package com.library.library_management.exceptions;

public class BookNotFoundException extends RuntimeException {
    public BookNotFoundException(String msg){
        super(msg);
    }
}
