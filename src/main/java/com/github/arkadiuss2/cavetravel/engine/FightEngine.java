package com.github.arkadiuss2.cavetravel.engine;

import com.github.arkadiuss2.cavetravel.domain.character.CharacterI;
import com.github.arkadiuss2.cavetravel.domain.character.PlayerCharacter;
import com.github.arkadiuss2.cavetravel.domain.character.powers.HealthPowerValue;

import java.util.List;
import java.util.Optional;

public class FightEngine {

    public FightResult fight(PlayerCharacter player, List<CharacterI> enemies) {

        if (enemies.size() == 0) {
            System.out.println("There are no enemies!");
        } else {
            System.out.println("Starting fight!");
        }

        Optional<CharacterI> optionalMonster;

        FightResult fightResult = new FightResult();
        fightResult.setSummary(FightResult.Summary.WIN);

        while (enemies.size() != 0) {
            System.out.println("- - - - - - - - ROUND START - - - - - - - - - -");
            optionalMonster = enemies.stream().filter(enemy -> enemy.getHp().getCurrentValue() > 0).findFirst();

            if (optionalMonster.isPresent()) {
                CharacterI monster = optionalMonster.get();

                double playerHitValue = player.getStrength().getSkillValue();
                double monsterHitValue = monster.getStrength().getSkillValue();

                hitCharacter(playerHitValue, player, monster);

                if (isDead(monster)) {
                    System.out.println("Monster die!!");
                    enemies.remove(monster);
                    fightResult.setExp(fightResult.getExp() + monster.getLevel().getCurrentValue());
                    fightResult.setGold(fightResult.getGold() + monster.getLevel().getCurrentValue() + 10);
                    continue;
                }

                hitCharacter(monsterHitValue, monster, player);
                if (isDead(player)) {
                    System.out.println("Player die!!");
                    fightResult.setSummary(FightResult.Summary.LOSE);
                    break;
                }
            }
            System.out.println("- - - - - - - - ROUND END - - - - - - - - - -");
        }

        return fightResult;
    }

    private boolean isDead(CharacterI monster) {
        return monster.getHp().getCurrentValue() <= 0;
    }


    private void hitCharacter(double hitValue, CharacterI hitter, CharacterI receiver) {
        System.out.printf("%s hit with: %s %s%n", hitter.getName(), hitValue, receiver.getName());
        HealthPowerValue hp = receiver.getHp();
        hp.subtractCurrentValue(hitValue);
        System.out.printf("%s now have %s%n", receiver.getName(), receiver.getHp());
    }

}
