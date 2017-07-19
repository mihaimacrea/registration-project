package com.registration.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.FORBIDDEN)
public class ValidationException extends Exception {
    public ValidationException(String msg) {
        super(msg);
    }
}
