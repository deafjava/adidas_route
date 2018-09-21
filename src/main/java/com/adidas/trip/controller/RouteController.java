package com.adidas.trip.controller;

import com.adidas.trip.service.RouteService;
import domain.Route;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController("/route")
public class RouteController {

    @Autowired
    private RouteService routeService;

    @GetMapping("/origin/{city}/{state}/{country}")
    public List<Route> listRoutesFromOrigin(
            @PathVariable String city,
            @PathVariable String state,
            @PathVariable String country) {

        return routeService.findAllByOriginCity(Optional.ofNullable(city), Optional.of(state), Optional.ofNullable(country));
    }

    @GetMapping("/destiny/{city}/{state}/{country}")
    public List<Route> listRoutesFromDestiny(
            @PathVariable String city,
            @PathVariable String state,
            @PathVariable String country) {

        return routeService.findAllByDestinyCity(Optional.ofNullable(city), Optional.of(state), Optional.ofNullable(country));
    }
}
