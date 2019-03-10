package com.github.arkadiuss2.cavetravel.application.fight_engine;

public class FightResult {

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("FightResult{");
        sb.append("exp=").append(exp);
        sb.append(", gold=").append(gold);
        sb.append(", summary=").append(summary);
        sb.append('}');
        return sb.toString();
    }

    public enum Summary {
        WIN, LOSE, RUN
    }

    private double exp;
    private double gold;
    private Summary summary;


    public double getExp() {
        return exp;
    }

    public void setExp(double exp) {
        this.exp = exp;
    }

    public double getGold() {
        return gold;
    }

    public void setGold(double gold) {
        this.gold = gold;
    }

    public Summary getSummary() {
        return summary;
    }

    public void setSummary(Summary summary) {
        this.summary = summary;
    }
}
