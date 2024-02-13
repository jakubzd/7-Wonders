package com.jakubzd.SevenWonders.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "players_game_info")
public class PlayerGameInfo {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "game_log_id")
    private GameLog gameLog;
    @ManyToOne
    @JoinColumn(name = "player_id")
    private Player player;
    @Column(name = "score")
    private int score;
    @Column(name = "city")
    private String city;
}
