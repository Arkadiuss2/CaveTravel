package com.github.arkadiuss2.cavetravel.domain.character.powers;

public interface BarValue {
    /**
     * Subtract value to current
     *
     * @param subtract value to current
     * @return true if limit exceeded otherwise false
     */
    boolean subtractCurrentBar(double subtract);

    /**
     * Add value to current
     *
     * @param add value to current
     * @return true if limit exceeded otherwise false
     */
    boolean addCurrentBar(double add);

    double getMaxBar();

    void setMaxBar(double maxBar);

    double getCurrentBar();

    void setCurrentBar(double currentBar);

}
