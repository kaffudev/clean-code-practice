package com.kf.example.usecase.exception;

public class UserIsPresentException extends RuntimeException {
    public UserIsPresentException(final String email) {
        super("user with email : " + email + " : already exsist");
    }
}
