package com.adidas.trip.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.time.LocalTime;

@Entity
@Data
@EqualsAndHashCode(of = "id")
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

    @Column(name = "departure_time")
    private LocalTime departureTime;

    @Column(name = "arrival_time")
    private LocalTime arrivalTime;
}
