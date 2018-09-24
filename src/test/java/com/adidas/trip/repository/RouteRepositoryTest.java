package com.adidas.trip.repository;

import com.adidas.trip.domain.City;
import com.adidas.trip.domain.Route;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Optional;

import static org.testng.Assert.assertEquals;

@SpringBootTest
@ActiveProfiles("test")
public class RouteRepositoryTest extends AbstractTestNGSpringContextTests {

    @Autowired
    private RouteRepository routeRepository;

    @Autowired
    private CityRepository cityRepository;

    @Test
    public void getRoutesTest() {

        Optional<City> cityOpt = cityRepository.findByIata("MAD");

        List<Route> routes = routeRepository.findAllByOriginCity(cityOpt.get());

        assertEquals(routes.size(), 10L);
    }
}