package domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Entity
@Data
@EqualsAndHashCode(of = "id")
public class State {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @JoinColumn(name = "country_id")
    @ManyToOne(fetch = FetchType.EAGER)
    private Country country;

    @Column(name = "iso_code")
    private String isoCode;
}
