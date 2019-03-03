package com.github.arkadiuss2.cavetravel.domain.character.powers;

public interface Power {

    boolean removePower(double removePower);

    boolean recoverPower(double recoverPower);

    double getMaxPower();

    void setMaxPower(double maxPower);

    double getCurrentPower();

    void setCurrentPower(double power);

}
