package com.finartz.ticket.exception;

/**
 * Created by promegalex on 11.03.2020 18:33
 */
public class InvalidException extends RuntimeException {
    private final String message;

    public InvalidException(String message) {
        super(message);
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
