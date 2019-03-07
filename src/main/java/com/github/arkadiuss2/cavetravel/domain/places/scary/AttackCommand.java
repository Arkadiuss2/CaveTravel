package com.github.arkadiuss2.cavetravel.domain.places.scary;

import com.github.arkadiuss2.cavetravel.domain.character.CharacterI;
import com.github.arkadiuss2.cavetravel.domain.character.powers.HealthPowerValue;
import com.github.arkadiuss2.cavetravel.engine.commands.Command;
import com.github.arkadiuss2.cavetravel.engine.commands.CommandCategory;

import java.util.List;
import java.util.Optional;

public class AttackCommand implements Command {

    private CharacterI player;
    private List<CharacterI> characterIList;

    public AttackCommand(CharacterI player, List<CharacterI> characterIList) {
        this.player = player;
        this.characterIList = characterIList;
    }

    @Override
    public String getCommandName() {
        return "attack";
    }

    @Override
    public boolean isMatched(String[] splitInput) {
        return splitInput.length == 1 && getCommandName().equals(splitInput[0]);
    }

    @Override
    public CommandCategory getCategory() {
        return null;
    }

    @Override
    public void execute() {

//        Optional<CharacterI> firstMonster = characterIList.stream().filter(x -> !player.equals(x)).findFirst();
//
//        if (firstMonster.isPresent()) {
//            hitMonster(player.getStrength().getSkillValue(), firstMonster.get());
//        } else {
//            System.out.println("there are no monsters!");
//        }
//
    }
//
//    private void hitMonster(double hitValue, CharacterI monster) {
//
//        System.out.println("You hit with:" + hitValue + "Monster:" + monster.getName());
//
//        HealthPowerValue hp = monster.getHp();
//        hp.setCurrentValue(hp.getCurrentValue() - hitValue);
//        System.out.println("Monster now have " + monster.getHp());
//        if (monster.getHp().getCurrentValue() <= 0) {
//            System.out.println("Monster die!!");
//            characterIList.remove(monster);
//        }
//    }


}
