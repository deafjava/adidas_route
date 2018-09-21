package com.adidas.trip.service;

import com.adidas.trip.exception.DestinyCityNotFoundException;
import com.adidas.trip.exception.OriginCityNotFoundException;
import com.adidas.trip.exception.RouteNotFoundException;
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
    public List<Route> findAllByOriginCity(Optional<String> iataOpt) {

        Optional<City> cityOpt = cityRepository.findByIata(iataOpt.orElseThrow(OriginCityNotFoundException::new));

        return routeRepository.findAllByOriginCity(cityOpt.orElseThrow(RouteNotFoundException::new));
    }

    @Override
    public List<Route> findAllByDestinyCity(Optional<String> iataOpt) {

        Optional<City> cityOpt = cityRepository.findByIata(iataOpt.orElseThrow(DestinyCityNotFoundException::new));

        return routeRepository.findAllByDestinyCity(cityOpt.orElseThrow(RouteNotFoundException::new));
    }
}
