package com.github.arkadiuss2.cavetravel.application.engine.map;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class MapPosition {

    public static final MapPosition EMPTY = new MapPosition(-1, -1);
    private int x;
    private int y;

    public MapPosition() {
    }

    public MapPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }


    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
