package com.jakubzd.SevenWonders.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
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
    @ManyToOne
    @JoinColumn(name = "wonder_id")
    private Wonder wonder;

    public PlayerGameInfo(GameLog gameLog, Player player, int score, Wonder wonder) {
        this.gameLog = gameLog;
        this.player = player;
        this.score = score;
        this.wonder = wonder;
    }
}
