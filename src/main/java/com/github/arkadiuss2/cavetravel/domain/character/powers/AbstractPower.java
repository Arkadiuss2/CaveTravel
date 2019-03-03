package com.github.arkadiuss2.cavetravel.domain.character.powers;

import com.github.arkadiuss2.cavetravel.domain.character.WrongValueCharacterException;

public class AbstractPower implements Power {

    private double maxPower;

    private double currentPower;


    AbstractPower(double maxPower, double currentPower) {

        validateValues(maxPower, currentPower);

        this.maxPower = maxPower;
        this.currentPower = currentPower;

    }

    private void validateValues(double maxPower, double currentPower) {
        if (maxPower < 0 || currentPower < 0) {
            throw new WrongValueCharacterException("maxPower or currentPower cannot be less than zero");
        }
    }

    public boolean removePower(double removePower) {
        return false;
    }

    public boolean recoverPower(double recoverPower) {
        return false;
    }

    public double getMaxPower() {
        return maxPower;
    }

    public void setMaxPower(double maxPower) {
        this.maxPower = maxPower;
    }

    public double getCurrentPower() {
        return currentPower;
    }

    public void setCurrentPower(double currentPower) {
        this.currentPower = currentPower;
    }


}
