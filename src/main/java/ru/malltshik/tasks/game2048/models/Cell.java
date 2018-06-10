package ru.malltshik.tasks.game2048.models;

public class Cell {
    private int value = 2;
    private int x, y;

    Cell(int y, int x) {
        this.y = y;
        this.x = x;
    }

    boolean equal(Cell cell) {
        return this.value == cell.value;
    }

    int getX() {
        return x;
    }

    void setX(int x) {
        this.x = x;
    }

    int getY() {
        return y;
    }

    void setY(int y) {
        this.y = y;
    }

    void add(Cell cell) {
        this.value += cell.value;
    }

    int getValue() {
        return value;
    }
}
