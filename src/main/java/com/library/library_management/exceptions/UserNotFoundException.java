package com.library.library_management.exceptions;

public class UserNotFoundException extends RuntimeException {
    String msg;

    public UserNotFoundException( String msg) {
        this.msg = msg;
    }
}
