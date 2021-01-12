package com.problemfighter.pfspring.jwt.processor;


/**
 * Created by Touhid Mia on 11/09/2014.
 */
public class JWTException extends RuntimeException {

    public Object errorMessage;

    public JWTException() {
        super("JWT Processor Exception");
    }

    public JWTException(String message) {
        super(message);
    }
}
