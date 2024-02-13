package com.jakubzd.SevenWonders.game;

import com.jakubzd.SevenWonders.entity.Expansion;
import com.jakubzd.SevenWonders.entity.Player;
import com.jakubzd.SevenWonders.entity.Wonder;

import java.util.*;

public class DrawnGame {
    private final Map<Player, Wonder> playerWonderMap = new LinkedHashMap<>();

    DrawnGame(final List<Player> players, final List<Expansion> expansions) {
        final List<Wonder> wonders = getWondersFromExpansions(expansions);
        drawWonders(players, wonders);
    }

    private void drawWonders(final List<Player> players, final List<Wonder> wonders) {
        Collections.shuffle(players);
        Collections.shuffle(wonders);
        final Iterator<Wonder> wonderIterator = wonders.listIterator();
        for(Player player : players) {
            playerWonderMap.put(player, wonderIterator.next());
        }
    }

    private List<Wonder> getWondersFromExpansions(final List<Expansion> expansions) {
        final List<Wonder> wonders = new ArrayList<>();
        for(Expansion expansion: expansions) {
            wonders.addAll(expansion.getWonders());
        }
        return wonders;
    }
}
