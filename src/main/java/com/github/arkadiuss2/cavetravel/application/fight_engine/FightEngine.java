package com.github.arkadiuss2.cavetravel.application.fight_engine;

import com.github.arkadiuss2.cavetravel.domain.character.CharacterI;
import com.github.arkadiuss2.cavetravel.domain.character.PlayerCharacter;

import java.util.List;

public interface FightEngine {

    FightResult fight(PlayerCharacter player, List<CharacterI> enemies);

}
