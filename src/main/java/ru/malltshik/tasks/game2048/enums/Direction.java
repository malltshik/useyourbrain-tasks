package ru.malltshik.tasks.game2048.enums;

import ru.malltshik.tasks.game2048.models.Cell;

public enum Direction {
    UP(-1,0), DOWN(1,0), RIGHT(0,1), LEFT(0,-1);

    public final int xShift;
    public final int yShift;

    Direction(int y, int x) {
        this.yShift = y;
        this.xShift = x;
    }
}
