package com.jakubzd.SevenWonders.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
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

    public List<Wonder> getWonders() {
        return new ArrayList<>(wonders);
    }
}
