package com.adidas.trip.exception;

public class DestinyCityNotFoundException extends RuntimeException {
    public DestinyCityNotFoundException() {
        super("Destiny City not found in our systems!");

    }
}
