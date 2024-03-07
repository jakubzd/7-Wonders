package com.jakubzd.SevenWonders.service;

import com.jakubzd.SevenWonders.dto.PlayerGameInfoDto;
import com.jakubzd.SevenWonders.entity.GameLog;
import com.jakubzd.SevenWonders.entity.Player;
import com.jakubzd.SevenWonders.entity.PlayerGameInfo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;
import java.util.Map;

public class GameLogServiceImpl implements GameLogService {
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void save(List<PlayerGameInfoDto> playersScores) {
        final GameLog gameLog = new GameLog();
        final Map<Player, PlayerGameInfo> playerScoresMap = gameLog.getPlayerScoresMap();
        for(PlayerGameInfoDto dto : playersScores) {
            PlayerGameInfo info = new PlayerGameInfo(gameLog, dto.getPlayer(), dto.getScore(), dto.getWonder());
            playerScoresMap.put(dto.getPlayer(), info);
        }
        gameLog.setPlayerScoresMap(playerScoresMap);
        entityManager.persist(gameLog);
    }
}
