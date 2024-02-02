package com.jakubzd.SevenWonders.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Entity
public class GameLog {

    @Id
    @Column(name = "id")
    private Long id;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinTable(name = "player_game_info_mapping",
            joinColumns = {@JoinColumn(name = "game_log_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "player_game_info_id", referencedColumnName = "id")})
    @MapKeyJoinColumn(name = "player_id")
    private Map<Player, PlayerGameInfo> playerScoresMap = new HashMap<>();
}
