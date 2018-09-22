package com.adidas.trip.service;

import com.adidas.trip.domain.Route;

import java.util.List;

public interface RouteService {

    List<Route> findAllByOriginCity(String iata);
}
