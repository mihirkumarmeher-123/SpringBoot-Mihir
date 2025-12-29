package com.myprojects.product.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//Implemented but don't know where to throw this exception
@ResponseStatus(value = HttpStatus.CONFLICT)
public class UnauthorizedException extends RuntimeException{
    public UnauthorizedException(String message) {
        super(message);
    }
}
