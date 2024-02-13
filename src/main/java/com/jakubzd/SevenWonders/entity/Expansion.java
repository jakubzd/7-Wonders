package com.jakubzd.SevenWonders.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Data
@Entity
@Table(name = "expansions")
public class Expansion {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "cards_to_add")
    private String cardsToAdd;
    @OneToMany(mappedBy = "expansion")
    private Set<Wonder> wonders;
}
