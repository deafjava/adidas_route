package repository;

import domain.City;
import domain.Route;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RouteRepository extends JpaRepository<Route, Long> {

    List<Route> findAllByOriginCity(City city);

    List<Route> findAllByDestinyCity(City city);
}
