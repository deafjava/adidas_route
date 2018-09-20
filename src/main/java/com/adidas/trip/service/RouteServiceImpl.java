package com.adidas.trip.service;

import com.adidas.trip.exception.DestinyCityNotFoundException;
import com.adidas.trip.exception.OriginCityNotFoundException;
import domain.City;
import domain.Route;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.CityRepository;
import repository.RouteRepository;

import java.util.List;
import java.util.Optional;

@Service
public class RouteServiceImpl implements RouteService {

    @Autowired
    private RouteRepository routeRepository;

    @Autowired
    private CityRepository cityRepository;

    @Override
    public List<Route> findAllByOriginCity(Optional<String> city, Optional<String> state) throws OriginCityNotFoundException {

        Optional citOpt = cityRepository.findByName

        return routeRepository.findAllByOriginCity(cityOpt.orElseThrow(OriginCityNotFoundException::new));
    }

    @Override
    public List<Route> findAllByDestinyCity(Optional<String> city) throws DestinyCityNotFoundException {

        return routeRepository.findAllByDestinyCity(cityOpt.orElseThrow(DestinyCityNotFoundException::new));

    }
}
