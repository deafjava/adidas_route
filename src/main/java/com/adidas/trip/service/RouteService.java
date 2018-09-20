package com.adidas.trip.service;

import com.adidas.trip.exception.DestinyCityNotFoundException;
import com.adidas.trip.exception.OriginCityNotFoundException;
import domain.Route;

import java.util.List;
import java.util.Optional;

public interface RouteService {

    List<Route> findAllByOriginCity(Optional<String> city) throws OriginCityNotFoundException;

    List<Route> findAllByDestinyCity(Optional<String> city) throws DestinyCityNotFoundException;
}
