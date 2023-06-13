package com.library.library_management.exceptions;

public class CategoryNotFoundException extends RuntimeException{
    public CategoryNotFoundException(String msg) {
        super(msg);
    }
}
