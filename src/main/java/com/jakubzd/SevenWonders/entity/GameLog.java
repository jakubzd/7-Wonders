package com.jakubzd.SevenWonders.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
@Entity
@Table(name = "games_logs")
public class GameLog {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinTable(name = "player_game_info_mapping",
            joinColumns = {@JoinColumn(name = "game_log_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "player_game_info_id", referencedColumnName = "id")})
    @MapKeyJoinColumn(name = "player_id")
    private Map<Player, PlayerGameInfo> playerScoresMap = new HashMap<>();
}
