package com.github.arkadiuss2.cavetravel.map;

public class MapPosition {

    public static final MapPosition EMPTY = new MapPosition(-1, -1);
    private int x;
    private int y;

    private static MapPosition[][] mapArray = new MapPosition[Map.MAX_WIDTH][Map.MAX_HEIGHT];

    public static MapPosition position(int x, int y) {
        MapPosition mapPosition = mapArray[x][y];

        if (mapPosition == null) {
            mapArray[x][y] = new MapPosition(x, y);
        }
        return mapArray[x][y];
    }

    private MapPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }


    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }


    @Override
    public String toString() {
        return "{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
