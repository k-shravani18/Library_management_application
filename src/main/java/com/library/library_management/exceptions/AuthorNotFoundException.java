package com.library.library_management.exceptions;

public class AuthorNotFoundException extends RuntimeException {
    public AuthorNotFoundException(String msg) {
        super(msg);
    }
}
