package com.adidas.trip;

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

    @GetMapping("/origin/{city}")
    public List<Route> listRoutesFromOrigin(@PathVariable String city) {
        return routeService.findAllByOriginCity(Optional.ofNullable(city));
    }
}
