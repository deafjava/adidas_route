package com.adidas.trip.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Entity
@Data
@EqualsAndHashCode(of = "id")
@Table(name = "connections")
public class Connection {

    @Id
    @JsonIgnore
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name = "full_route_id")
    @ManyToOne(fetch = FetchType.EAGER)
    @JsonIgnore
    private Route fullRoute;

    @JoinColumn(name = "connection_route_id")
    @ManyToOne(fetch = FetchType.EAGER)
    private Route connectionRoute;

}
