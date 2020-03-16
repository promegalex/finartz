package com.finartz.ticket.exception;

/**
 * Created by promegalex on 11.03.2020 18:33
 */
public class FinartzNotFoundException extends RuntimeException {
    private final String message;

    public FinartzNotFoundException(String message) {
        super(message);
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
