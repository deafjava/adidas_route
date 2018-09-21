package com.adidas.trip.service;

import domain.Route;

import java.util.List;
import java.util.Optional;

public interface RouteService {

    List<Route> findAllByOriginCity(Optional<String> iataOpt);

    List<Route> findAllByDestinyCity(Optional<String> iataOpt);
}
