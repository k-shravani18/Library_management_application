package com.library.library_management.exceptions;

public class MemberNotFoundException extends RuntimeException {
    String msg;

    public MemberNotFoundException(String msg) {
        this.msg = msg;
    }
}
