package com.adidas.trip.controller;

import com.adidas.trip.exception.IataNotFoundException;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class ErrorHubController {

    @ExceptionHandler(IataNotFoundException.class)
    public ResponseEntity<ResponseBodyError> noRouteError() {

        return ResponseEntity
                .unprocessableEntity()
                .body(new ResponseBodyError("There is no route with this iata code!"));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ResponseBodyError> genericError() {

        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new ResponseBodyError("Oops! Something wrong happened!"));
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    public ResponseEntity<ResponseBodyError> notFoundError() {

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(new ResponseBodyError("Page not found!!"));
    }

    @Data
    @AllArgsConstructor
    private static class ResponseBodyError {
        private String cause;
    }

}
