package com.adidas.trip.repository;

import com.adidas.trip.domain.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import java.util.Optional;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;

@SpringBootTest
@ActiveProfiles("test")
public class CityRepositoryTest extends AbstractTestNGSpringContextTests {

    @Autowired
    private CityRepository cityRepository;

    @Test
    public void getCityTest() {

        Optional<City> cityOpt = cityRepository.findByIata("ZAZ");

        assertEquals(cityOpt.get().getName(), "Zaragoza");
    }

    @Test
    public void getNonExistingCityTest() {

        Optional<City> cityOpt = cityRepository.findByIata("NON");

        assertFalse(cityOpt.isPresent());
    }


}