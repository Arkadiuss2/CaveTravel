package com.github.arkadiuss2.cavetravel.engine.persistance;

import com.github.arkadiuss2.cavetravel.domain.character.PlayerCharacter;
import com.github.arkadiuss2.cavetravel.engine.map.GameMap;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Objects;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class GameData {

    private GameMap gameMap;
    private PlayerCharacter player;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GameData data = (GameData) o;
        return Objects.equals(gameMap, data.gameMap) &&
                Objects.equals(player, data.player);
    }

    @Override
    public int hashCode() {

        return Objects.hash(gameMap, player);
    }

    @Override
    public String toString() {
        return "GameData{" +
                "gameMap=" + gameMap +
                ", player=" + player +
                '}';
    }
}
