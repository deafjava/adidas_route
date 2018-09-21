package com.adidas.trip.controller;

import com.adidas.trip.exception.DestinyCityNotFoundException;
import com.adidas.trip.exception.OriginCityNotFoundException;
import com.adidas.trip.exception.RouteNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ErrorController {

    @ExceptionHandler({OriginCityNotFoundException.class, DestinyCityNotFoundException.class})
    @ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Something wrong with input city! Double check the iata code!")
    public void consultIataError() {

    }

    @ExceptionHandler(RouteNotFoundException.class)
    @ResponseStatus(code = HttpStatus.UNPROCESSABLE_ENTITY, reason = "There is no route from or to with this iata code!")
    public void noRouteError() {

    }

}
