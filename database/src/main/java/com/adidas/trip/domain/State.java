package com.adidas.trip.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Entity
@Data
@EqualsAndHashCode(of = "id")
public class State {

    @Id
    @JsonIgnore
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @JoinColumn(name = "country_id")
    @ManyToOne(fetch = FetchType.EAGER)
    private Country country;

    @Column(name = "iso_code")
    private String isoCode;
}
