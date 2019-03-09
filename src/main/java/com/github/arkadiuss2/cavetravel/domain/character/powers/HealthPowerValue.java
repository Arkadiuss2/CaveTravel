package com.github.arkadiuss2.cavetravel.domain.character.powers;

public class HealthPowerValue extends DefaultBarValue {

    public HealthPowerValue() {
    }

    public HealthPowerValue(double maxPower, double currentPower) {
        super(maxPower, currentPower);
    }

    @Override
    public String toString() {
        return "(" + getCurrentValue() + "/" + getMaxValue() + ") HP";
    }
}
