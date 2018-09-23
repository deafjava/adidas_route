package com.adidas.trip.service;

import com.adidas.trip.domain.Route;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;
import static org.testng.Assert.fail;


@SpringBootTest
@ActiveProfiles("test")
public class RouteServiceImplTest extends AbstractTestNGSpringContextTests {

    @Autowired
    private RouteService routeService;

    @Test
    public void happyWayOriginTest() {
        List<Route> routes = routeService.findAllByOriginCity("ZAZ");

        assertFalse(routes.isEmpty());
    }

    @Test
    public void happyWayOriginEmptyTest() {
        List<Route> routes = routeService.findAllByOriginCity("DFW");

        assertTrue(routes.isEmpty());
    }

    @Test
    public void noRouteTest() {
        //fail();
    }
}