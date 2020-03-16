package com.finartz.ticket.handler;

import com.finartz.ticket.exception.InvalidException;
import com.finartz.ticket.exception.FinartzNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by promegalex on 11.03.2020 18:44
 */
@ControllerAdvice
@Slf4j
@SuppressWarnings("unchecked")
public class ErrorHandler {
    final static String ERROR_KEY = "error";
    final static String ERROR_DESCRIPTION_KEY = "error_description";

    @ExceptionHandler(InvalidException.class)
    public ResponseEntity<Object> handleInvalidException(Exception ex, HttpServletRequest request,
                                                         HttpServletResponse response) {
        log.warn("Invalid value!", ex);
        return createErrorResponse("invalid_value", "Invalid value. " + ex.getMessage(), HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler(FinartzNotFoundException.class)
    public ResponseEntity<Object> handleTicketNotFoundException(Exception ex, HttpServletRequest request,
                                                                HttpServletResponse response) {
        log.warn("Null pointer exception handler!", ex);
        return createErrorResponse("event_limit_exceeded", "Event limit exceeded. " + ex.getMessage(), HttpStatus.NOT_FOUND);
    }

     protected ResponseEntity<Object> createErrorResponse(final String error, final String description, final HttpStatus httpStatus) {
        Map responseBody = new HashMap();
        responseBody.put(ERROR_KEY, error);
        responseBody.put(ERROR_DESCRIPTION_KEY, description);
        return new ResponseEntity<>(responseBody, httpStatus);
    }
}
