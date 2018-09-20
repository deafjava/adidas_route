package domain;


import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@EqualsAndHashCode(of = "id")
public class Route {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name = "origin_city_id")
    @ManyToOne(fetch = FetchType.EAGER)
    private City originCity;

    @JoinColumn(name = "destiny_city_id")
    @ManyToOne(fetch = FetchType.EAGER)
    private City destinyCity;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "departure_time")
    private Date departureTime;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "arrival_time")
    private Date arrivalTime;
}
