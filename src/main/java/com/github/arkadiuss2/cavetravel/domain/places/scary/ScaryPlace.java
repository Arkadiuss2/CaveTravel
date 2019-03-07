package com.github.arkadiuss2.cavetravel.domain.places.scary;

import com.github.arkadiuss2.cavetravel.domain.character.CharacterI;
import com.github.arkadiuss2.cavetravel.engine.commands.Command;
import com.github.arkadiuss2.cavetravel.engine.map.places.Place;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ScaryPlace implements Place {

    private List<CharacterI> characters = new ArrayList<>();

    @Override
    public String getDescription() {
        return "Scary Place.";
    }

    @Override
    public List<CharacterI> getCharacters() {
        return characters;
    }

    @Override
    public void addCharacter(CharacterI character) {
        characters.add(character);
    }

    @Override
    public void removeCharacter(CharacterI character) {
        characters.remove(character);
    }

    @Override
    public List<Command> getAvailableMoves() {
        List<Command> commandList = new ArrayList<>();
        Optional<CharacterI> optionalPlayer = getPlayer(characters);
        if (!optionalPlayer.isPresent()) {
            throw new UnsupportedOperationException("Player is not present!");
        }
        CharacterI player = optionalPlayer.get();

        commandList.add(new AttackCommand(player, characters));
        return commandList;
    }
}
