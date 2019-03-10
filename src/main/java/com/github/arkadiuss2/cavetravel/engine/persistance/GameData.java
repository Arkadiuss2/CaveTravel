package com.github.arkadiuss2.cavetravel.engine.persistance;

import com.github.arkadiuss2.cavetravel.domain.character.PlayerCharacter;
import com.github.arkadiuss2.cavetravel.engine.map.GameMap;
import com.github.arkadiuss2.cavetravel.engine.map.MapPosition;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Objects;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class GameData {

    private GameMap gameMap;
    private PlayerCharacter player;
    private MapPosition playerPosition;
    private boolean isGameEnded = false;


    public boolean isGameActive() {
        if (getPlayer() == null) {
            return false;
        }
        double currentHP = getPlayer().getHp().getCurrentValue();
        return currentHP > 0 && !isGameEnded;
    }

    public PlayerCharacter getPlayer() {
        return player;
    }

    public void setPlayer(PlayerCharacter player) {
        this.player = player;
    }

    public GameMap getGameMap() {
        return gameMap;
    }

    public void setGameMap(GameMap gameMap) {
        this.gameMap = gameMap;
    }

    public MapPosition getPlayerPosition() {
        return playerPosition;
    }

    public void setPlayerPosition(MapPosition playerPosition) {
        this.playerPosition = playerPosition;
    }

    public boolean isGameEnded() {
        return isGameEnded;
    }

    public void setGameEnded(boolean isGameEnded) {
        this.isGameEnded = isGameEnded;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GameData data = (GameData) o;
        return Objects.equals(gameMap, data.gameMap) &&
                Objects.equals(player, data.player) &&
                Objects.equals(playerPosition, data.playerPosition);
    }

    @Override
    public int hashCode() {

        return Objects.hash(gameMap, player, playerPosition);
    }

    @Override
    public String toString() {
        return String.format("GameData{, player=%s, playerPosition=%s, gameMap=%s}", player, playerPosition, gameMap);
    }
}
