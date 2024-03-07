package com.jakubzd.SevenWonders.service;

import com.jakubzd.SevenWonders.dto.PlayerGameInfoDto;

import java.util.List;

public interface GameLogService {
    void save(List<PlayerGameInfoDto> playersScores);
}
