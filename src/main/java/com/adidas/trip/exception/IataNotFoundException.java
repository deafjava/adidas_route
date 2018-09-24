package com.adidas.trip.exception;

public class IataNotFoundException extends RuntimeException {

    public IataNotFoundException() {
        super("This IATA doesn't exist!");
    }
}
