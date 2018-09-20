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

    private String name;

    private String uniquePublicName;

    @JoinColumn(name = "state_id")
    @ManyToOne(fetch = FetchType.EAGER)
    private State state;
}
