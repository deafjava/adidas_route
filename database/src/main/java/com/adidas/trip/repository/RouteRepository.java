package com.adidas.trip.repository;


import com.adidas.trip.domain.City;
import com.adidas.trip.domain.Route;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RouteRepository extends JpaRepository<Route, Long> {

    List<Route> findAllByOriginCity(City city);

}
