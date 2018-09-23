package com.adidas.trip.domain;


import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.time.LocalTime;
import java.util.List;

@Entity
@Data
@EqualsAndHashCode(of = "id")
@Table(name = "route")
public class Route {

    @Id
    @JsonIgnore
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name = "origin_city_id")
    @ManyToOne(fetch = FetchType.EAGER)
    private City originCity;

    @JoinColumn(name = "destiny_city_id")
    @ManyToOne(fetch = FetchType.EAGER)
    private City destinyCity;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "fullRoute")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Connection> connections;

    @Column(name = "departure_time")
    private LocalTime departureTime;

    @Column(name = "arrival_time")
    private LocalTime arrivalTime;

    @JsonGetter("departureTime")
    public String getDepartureTime() {
        return departureTime.toString();
    }

    @JsonGetter("arrivalTime")
    public String getArrivalTime() {
        return arrivalTime.toString();
    }
}
