package com.adidas.trip.service;

import com.adidas.trip.domain.City;
import com.adidas.trip.domain.Route;
import com.adidas.trip.exception.RouteNotFoundException;
import com.adidas.trip.repository.CityRepository;
import com.adidas.trip.repository.RouteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class RouteServiceImpl implements RouteService {

    @Autowired
    private RouteRepository routeRepository;

    @Autowired
    private CityRepository cityRepository;

    @Override
    @Transactional
    public List<Route> findAllByOriginCity(String iata) {

        Optional<City> cityOpt = cityRepository.findByIata(iata);

        return routeRepository.findAllByOriginCity(cityOpt.orElseThrow(RouteNotFoundException::new));
    }
}
