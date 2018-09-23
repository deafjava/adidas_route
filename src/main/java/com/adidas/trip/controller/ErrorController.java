package com.adidas.trip.controller;

import com.adidas.trip.exception.RouteNotFoundException;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@CrossOrigin(origins = "http://192.168.3.11:8082/")
public class ErrorController {

    @ExceptionHandler(RouteNotFoundException.class)
    public ResponseEntity<ResponseBodyError> noRouteError() {

        return ResponseEntity
                .unprocessableEntity()
                .body(new ResponseBodyError("There is no route with this iata code!"));
    }

    @Data
    @AllArgsConstructor
    private static class ResponseBodyError {
        private String cause;
    }

}
