package com.library.library_management.exceptions;

public class BookAlreadyExistedException extends RuntimeException {
    public BookAlreadyExistedException(String message) {
        super(message);
    }
}
