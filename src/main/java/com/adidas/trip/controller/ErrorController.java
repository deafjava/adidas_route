package com.adidas.trip.controller;

import com.adidas.trip.exception.RouteNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ErrorController {

    @ExceptionHandler(RouteNotFoundException.class)
    @ResponseStatus(code = HttpStatus.UNPROCESSABLE_ENTITY, reason = "There is no route from or to with this iata code!")
    public void noRouteError() {

    }

}
