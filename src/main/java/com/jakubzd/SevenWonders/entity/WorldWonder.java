package com.jakubzd.SevenWonders.entity;

import jakarta.persistence.*;

@Entity
public class WorldWonder {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(name = "name")
    String name;
    @ManyToOne
    @JoinColumn(name = "expansion_id")
    Expansion expansion;
}
