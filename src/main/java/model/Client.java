package model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.util.*;

@Entity
@Table(name = "client")
@Data
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    @Size(min = 3, max = 200)
    private String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "client")
    @ToString.Exclude
    private List<Ticket> tickets = new ArrayList<>();
}