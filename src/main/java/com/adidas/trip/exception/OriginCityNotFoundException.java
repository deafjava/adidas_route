package com.adidas.trip.exception;

public class OriginCityNotFoundException extends RuntimeException {

    public OriginCityNotFoundException() {
        super("Origin City not found in our systems!");
    }
}
