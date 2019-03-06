package com.github.arkadiuss2.cavetravel.engine;


import com.github.arkadiuss2.cavetravel.domain.character.CharacterI;
import com.github.arkadiuss2.cavetravel.map.Map;
import com.github.arkadiuss2.cavetravel.map.MapGenerator;
import com.github.arkadiuss2.cavetravel.map.MapPosition;

import static com.github.arkadiuss2.cavetravel.map.MapPosition.position;


public class Engine {

    private MapPosition playerPosition = position(0, 0);
    private CharacterI player;
    private Map map;


    public void starNewGame(CharacterI player) {
        this.player = player;

        initializeGame();
        System.out.println("Game Started..");
//
//        startingMove();
//
//        fightWithMonsters();
//
//        doNextMove();

    }

    private void startingMove() {

        map.placePlayerInto(player, playerPosition);

        StoryTeller storyTeller = new StoryTeller(map);
        storyTeller.tellStory(playerPosition);

    }

    private void initializeGame() {
        map = MapGenerator.generateMap(10, 10);

    }

//    private void doNextMove() {
//        if (hasSurvive()) {
//            System.out.println("You survive!");
//            System.out.println("Where do you want to go?!");
//
//            moveToNextDestination();
//
//        } else {
//            System.out.println("You die");
//            System.out.println("Thank you for playing!");
//        }
//    }

//    private void moveToNextDestination() {
//        Optional<Direction> mapInput = ConsoleInput.getMapInput();
//        if (mapInput.isPresent()) {
//            map.placePlayerInto(player, playerPosition);
//        } else {
//            System.out.println("Unrecognized command!");
//        }
//    }

    private boolean hasSurvive() {
        return player.getHp().getCurrentBar() > 0;
    }

    private void fightWithMonsters() {
        System.out.println("You fight with monsters!!");
    }


}


