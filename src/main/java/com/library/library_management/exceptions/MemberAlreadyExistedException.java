package com.library.library_management.exceptions;

public class MemberAlreadyExistedException extends RuntimeException {
    public MemberAlreadyExistedException(String message) {
        super(message);
    }
}
