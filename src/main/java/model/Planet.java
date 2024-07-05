package model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.util.*;

@Entity
@Table(name = "planet")
@Data
public class Planet {
    @Id
    @Column(name = "id")
    @Pattern(regexp = "^[A-Z0-9]+$")
    private String id;
    @Column(name = "name")
    @Size(min = 1, max = 500)
    private String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fromPlanet")
    @ToString.Exclude
    private List<Ticket> fromPlanetTickets = new ArrayList<>();
    @ToString.Exclude
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "toPlanet")
    private List<Ticket> toPlanetTickets = new ArrayList<>();
}
