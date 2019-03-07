package com.github.arkadiuss2.cavetravel.domain.character.powers;

import com.github.arkadiuss2.cavetravel.domain.character.WrongValueCharacterException;

public class DefaultBarValue implements BarValue {

    private double maxValue = 1;
    private double currentValue = 0;

    public DefaultBarValue() {
    }

    public DefaultBarValue(double maxValue, double currentValue) {

        validateValues(maxValue, currentValue);

        this.maxValue = maxValue;
        this.currentValue = currentValue;

    }

    private void validateValues(double maxPower, double currentPower) {
        if (maxPower < 0 || currentPower < 0) {
            throw new WrongValueCharacterException("maxBar or currentBar cannot be less than zero");
        }
    }

    public boolean subtractCurrentValue(double subtractValue) {
        currentValue -= subtractValue;
        if (currentValue < 0) {
            currentValue = 0;
            return true;
        } else {
            return false;
        }
    }

    public boolean addCurrentValue(double addValue) {
        currentValue += addValue;
        if (currentValue > maxValue) {
            currentValue = maxValue;
            return true;
        } else {
            return false;
        }

    }

    @Override
    public double getMaxValue() {
        return maxValue;
    }

    @Override
    public void setMaxValue(double maxValue) {
        this.maxValue = maxValue;
    }

    @Override
    public double getCurrentValue() {
        return currentValue;
    }

    @Override
    public void setCurrentValue(double currentValue) {
        this.currentValue = currentValue;
    }


}
