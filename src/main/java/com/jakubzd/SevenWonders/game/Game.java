package com.jakubzd.SevenWonders.game;

import com.jakubzd.SevenWonders.entity.Expansion;
import com.jakubzd.SevenWonders.entity.Player;
import com.jakubzd.SevenWonders.entity.WorldWonder;
import lombok.Data;

import java.util.List;
import java.util.Map;


@Data
public class Game {
    private List<String> players;
    private List<Expansion> expansions;
    private Map<Player, WorldWonder> cities;

    public Game(List<String> players) {
        this.players = players;
    }
}
