package com.adidas.trip.exception;

public class RouteNotFoundException extends RuntimeException {

    public RouteNotFoundException() {
        super("Route doesn't exist for this city!");
    }
}
