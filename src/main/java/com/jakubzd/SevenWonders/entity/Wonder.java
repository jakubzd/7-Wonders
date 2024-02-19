package com.jakubzd.SevenWonders.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;

@Entity
@Table(name = "wonders")
@AllArgsConstructor
public class Wonder {
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
