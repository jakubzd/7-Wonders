package com.jakubzd.SevenWonders.game;

import com.jakubzd.SevenWonders.entity.Expansion;
import com.jakubzd.SevenWonders.entity.Player;
import com.jakubzd.SevenWonders.entity.Wonder;
import com.jakubzd.SevenWonders.repository.WonderRepository;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

public class DrawnGame {

    private final WonderRepository repository;
    @Getter
    private Map<Player, Wonder> playerWonderMap = new LinkedHashMap<>();

    @Autowired
    DrawnGame(WonderRepository repository) {
        this.repository = repository;
    }

    public void draw(final List<Player> players, final List<Expansion> expansions) {
        final List<Wonder> wonders = getAllWonders(expansions);
        playerWonderMap = drawWonders(players, wonders);
    }

    public static Map<Player, Wonder> drawWonders(final List<Player> players, final List<Wonder> wonders) {
        Map<Player, Wonder> map = new LinkedHashMap<>();
        Collections.shuffle(players);
        Collections.shuffle(wonders);
        final Iterator<Wonder> wonderIterator = wonders.listIterator();
        for(final Player player : players) {
            map.put(player, wonderIterator.next());
        }
        return map;
    }

    List<Wonder> getAllWonders(final List<Expansion> expansions) {
        final List<Wonder> wonders = repository.findByExpansion(null);
        if (expansions != null) {
            for(final Expansion expansion : expansions) {
                wonders.addAll(expansion.getWonders());
            }
        }
        return wonders;
    }
}
