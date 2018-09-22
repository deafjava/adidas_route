package com.adidas.trip.controller;

import com.adidas.trip.domain.Route;
import com.adidas.trip.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:8082/")
public class RouteController {

    @Autowired
    private RouteService routeService;

    @GetMapping("/route/{city}")
    public List<Route> listRoutesFromOrigin(
            @PathVariable String city) {

        return routeService.findAllByOriginCity(city);
    }
}
