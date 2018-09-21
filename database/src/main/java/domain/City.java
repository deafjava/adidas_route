package domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Entity
@Data
@EqualsAndHashCode(of = "id")
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String iata;

    private String name;

    @JoinColumn(name = "state_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private State state;
}
