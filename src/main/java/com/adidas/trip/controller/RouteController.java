package com.adidas.trip.controller;

import com.adidas.trip.domain.Route;
import com.adidas.trip.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/route")
public class RouteController {

    @Autowired
    private RouteService routeService;

    @GetMapping("/origin/{city}")
    public List<Route> listRoutesFromOrigin(
            @PathVariable String city) {

        return routeService.findAllByOriginCity(city);
    }

    @GetMapping("/destiny/{city}")
    public List<Route> listRoutesFromDestiny(
            @PathVariable String city) {

        return routeService.findAllByDestinyCity(city);
    }
}
