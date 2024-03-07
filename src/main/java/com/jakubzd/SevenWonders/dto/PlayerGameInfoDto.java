package com.jakubzd.SevenWonders.dto;

import com.jakubzd.SevenWonders.entity.Player;
import com.jakubzd.SevenWonders.entity.Wonder;
import lombok.Data;

@Data
public class PlayerGameInfoDto {
    private Player player;
    private int score;
    private Wonder wonder;
}
