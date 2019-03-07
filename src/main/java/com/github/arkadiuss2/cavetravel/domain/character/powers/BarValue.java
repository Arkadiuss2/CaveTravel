package com.github.arkadiuss2.cavetravel.domain.character.powers;

public interface BarValue {
    /**
     * Subtract value to current
     *
     * @param subtract value to current
     * @return true if limit exceeded otherwise false
     */
    boolean subtractCurrentValue(double subtract);

    /**
     * Add value to current
     *
     * @param add value to current
     * @return true if limit exceeded otherwise false
     */
    boolean addCurrentValue(double add);

    double getMaxValue();

    void setMaxValue(double maxBar);

    double getCurrentValue();

    void setCurrentValue(double currentBar);

}
