package com.finartz.ticket.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Collections;

/**
 * Created by promegalex on 13.03.2020 09:29
 */
public abstract class AbstractController {
    private static final String MESSAGE_KEY = "message";

    protected ResponseEntity<Object> createResponse(final String message, final HttpStatus httpStatus) {
        return new ResponseEntity<>(Collections.singletonMap(MESSAGE_KEY, message), httpStatus);
    }

    protected ResponseEntity<Object> createResponse(final Object responseMessages, final HttpStatus httpStatus) {
        return new ResponseEntity<>(responseMessages, httpStatus);
    }
}
