package com.github.arkadiuss2.cavetravel.domain.character.powers;

import com.github.arkadiuss2.cavetravel.domain.character.WrongValueCharacterException;

public class DefaultBarValue implements BarValue {

    private double maxBar = 1;

    private double currentBar = 0;

    public DefaultBarValue() {
    }

    public DefaultBarValue(double maxBar, double currentBar) {

        validateValues(maxBar, currentBar);

        this.maxBar = maxBar;
        this.currentBar = currentBar;

    }

    private void validateValues(double maxPower, double currentPower) {
        if (maxPower < 0 || currentPower < 0) {
            throw new WrongValueCharacterException("maxBar or currentBar cannot be less than zero");
        }
    }

    public boolean subtractCurrentBar(double subtractValue) {
        currentBar -= subtractValue;
        if (currentBar < 0) {
            currentBar = 0;
            return true;
        } else {
            return false;
        }
    }

    public boolean addCurrentBar(double addValue) {
        currentBar += addValue;
        if (currentBar > maxBar) {
            currentBar = maxBar;
            return true;
        } else {
            return false;
        }

    }

    public double getMaxBar() {
        return maxBar;
    }

    public void setMaxBar(double maxPower) {
        this.maxBar = maxPower;
    }

    public double getCurrentBar() {
        return currentBar;
    }

    public void setCurrentBar(double currentBar) {
        this.currentBar = currentBar;
    }


}
