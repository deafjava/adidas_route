package com.adidas.trip.controller;

import com.adidas.trip.domain.City;
import com.adidas.trip.domain.Country;
import com.adidas.trip.domain.Route;
import com.adidas.trip.domain.State;
import com.adidas.trip.exception.IataNotFoundException;
import com.adidas.trip.service.RouteService;
import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;
import net.minidev.json.parser.JSONParser;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

@WebMvcTest(RouteController.class)
public class RouteControllerTest {

    private MockMvc mockMvc;

    private RouteService routeService;

    @BeforeClass
    public void setUp() {
        routeService = mock(RouteService.class);

        mockMvc = MockMvcBuilders
                .standaloneSetup(new RouteController(routeService))
                .setControllerAdvice(new ErrorHubController())
                .build();
    }

    @Test
    public void shouldReturnListOfRoutesTest() throws Exception {

        Route route = createRoute();

        String iata = route.getOriginCity().getIata();

        when(routeService.findAllByOriginCity(iata)).thenReturn(Collections.singletonList(route));

        MvcResult result = mockMvc.perform(get("/route/" + iata))
                .andExpect(status().isOk())
                .andReturn();

        verify(routeService).findAllByOriginCity(eq(iata));

        JSONParser jsonParser = new JSONParser(JSONParser.MODE_JSON_SIMPLE);
        JSONArray jsonArray = (JSONArray) jsonParser.parse(result.getResponse().getContentAsString());

        assertEquals(jsonArray.size(), 1L);

        jsonArray
                .stream()
                .map(o -> (JSONObject) o)
                .map(jo -> (JSONObject) jo.get("originCity"))
                .findFirst()
                .ifPresent(joc -> assertEquals(joc.getAsString("iata"), iata));

    }

    @Test
    public void withExistingIataShouldReturnEmptyListOfRoutesTest() throws Exception {

        String iata = "ZAZ";

        when(routeService.findAllByOriginCity(iata)).thenReturn(new ArrayList<>());

        MvcResult result = mockMvc.perform(get("/route/" + iata))
                .andExpect(status().isOk())
                .andReturn();

        JSONParser jsonParser = new JSONParser(JSONParser.MODE_JSON_SIMPLE);
        JSONArray jsonArray = (JSONArray) jsonParser.parse(result.getResponse().getContentAsString());

        assertTrue(jsonArray.isEmpty());

    }

    @Test
    public void withNonExistingIataShouldReturnErrorUnprocessableEntityTest() throws Exception {

        String iata = "ZAZ";

        when(routeService.findAllByOriginCity(iata)).thenThrow(IataNotFoundException.class);

        mockMvc.perform(get("/route/" + iata))
                .andExpect(status().isUnprocessableEntity())
                .andReturn();

    }

    @Test
    public void everythingWentWrongTest() throws Exception {

        String iata = "NO";

        given(routeService.findAllByOriginCity(iata)).willAnswer(invocation -> {
            throw new Exception();
        });

        mockMvc.perform(get("/route/" + iata))
                .andExpect(status().isInternalServerError())
                .andReturn();

    }

    private Route createRoute() {

        Route route = new Route();
        route.setArrivalTime(LocalTime.of(12, 34, 42));
        route.setDepartureTime(LocalTime.of(13, 45, 20));

        Country c = new Country();
        c.setId(1L);
        c.setIsoCode("ES");
        c.setName("Zaragoza");

        State s1 = new State();
        s1.setCountry(c);
        s1.setId(1L);
        s1.setIsoCode("Z");
        s1.setName("Zaragoza");

        City c1 = new City();
        c1.setGmt(1);
        c1.setIata("ZAZ");
        c1.setId(1L);
        c1.setName("Zaragoza");
        c1.setState(s1);

        State s2 = new State();
        s2.setCountry(c);
        s2.setId(2L);
        s2.setIsoCode("M");
        s2.setName("Madrid");

        City c2 = new City();
        c2.setGmt(1);
        c2.setIata("MAD");
        c2.setId(1L);
        c2.setName("Zaragoza");
        c2.setState(s2);

        route.setOriginCity(c1);
        route.setDestinyCity(c2);
        route.setConnections(null);

        return route;
    }

}