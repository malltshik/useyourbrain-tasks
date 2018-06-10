package ru.malltshik.tasks.game2048.models;

import ru.malltshik.tasks.game2048.enums.Direction;
import ru.malltshik.tasks.game2048.exceptions.GameOverException;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class Field {

    private final Cell[][] cells;
    private final int size;
    private final Random random = new Random();
    private ArrayList<Point> freeCells;
    private boolean hasToAdd = false;

    public Field() throws GameOverException {
        this.size = 4;
        this.cells = new Cell[size][size];
        addRandomCell();
    }

    public Field(int size) throws GameOverException {
        this.size = size;
        this.cells = new Cell[size][size];
        addRandomCell();
    }

    public void move(Direction direction) throws GameOverException {

        switch (direction) {
            case LEFT:
            case DOWN:
                for (int y = this.size - 1; y >= 0; y--)
                    for (int x = 0; x < this.size; x++) {
                        Cell cell = this.cells[y][x];
                        if (cell != null) move(direction, cell);
                    }
                break;
            case RIGHT:
            case UP:
                for (int y = 0; y < this.size; y++)
                    for (int x = this.size - 1; x >= 0; x--) {
                        Cell cell = this.cells[y][x];
                        if (cell != null) move(direction, cell);
                    }
                break;
        }
        if(hasToAdd) addRandomCell();
        hasToAdd = false;
    }

    private void move(Direction direction, Cell cell) {
        Cell neighbour;
        while (true) {
            try {
                neighbour = this.cells[cell.getY() + direction.yShift][cell.getX() + direction.xShift];
                if(neighbour == null) {
                    this.cells[cell.getY()][cell.getX()] = null;
                    cell.setY(cell.getY() + direction.yShift);
                    cell.setX(cell.getX() + direction.xShift);
                    this.cells[cell.getY()][cell.getX()] = cell;
                    hasToAdd = true;
                } else if(neighbour.equal(cell)) {
                    neighbour.add(cell);
                    this.cells[cell.getY()][cell.getX()] = null;
                    hasToAdd = true;
                } else break;
            } catch (ArrayIndexOutOfBoundsException e) {
                break;
            }
        }
    }

    private void addRandomCell() throws GameOverException {
        if(this.isFull()) {
            if(!hasOptions()) throw new GameOverException("There are no free cells. Game over");
        } else {
            Point p = this.freeCells.get(random.nextInt(freeCells.size() > 1 ?
                    freeCells.size() - 1 : freeCells.size()));
            cells[p.y][p.x] = new Cell(p.y, p.x);
        }

    }

    private boolean hasOptions() {
        for (int y = 0; y < this.size; y++) {
            for (int x = 0; x < this.size; x++) {
                Cell cell = this.cells[y][x];
                try {
                    if(this.cells[cell.getY() - 1][cell.getX()].equal(cell)) return true;
                } catch (ArrayIndexOutOfBoundsException ignored) {}
                try {
                    if(this.cells[cell.getY() + 1][cell.getX()].equal(cell)) return true;
                } catch (ArrayIndexOutOfBoundsException ignored) {}
                try {
                    if(this.cells[cell.getY()][cell.getX() - 1].equal(cell)) return true;
                } catch (ArrayIndexOutOfBoundsException ignored) {}
                try {
                    if(this.cells[cell.getY()][cell.getX() + 1].equal(cell)) return true;
                } catch (ArrayIndexOutOfBoundsException ignored) {}
            }
        }
        return false;
    }

    private boolean isFull() {
        ArrayList<Point> freeCells = new ArrayList<>();
        for (int y = 0; y < this.size; y++) {
            for (int x = 0; x < this.size; x++) {
                if(this.cells[y][x] == null) freeCells.add(new Point(x, y));
            }
        }
        this.freeCells = freeCells;
        return freeCells.isEmpty();
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int y = 0; y < this.size; y++) {
            sb.append("|");
            for (int x = 0; x < this.size; x++) {
                sb.append(" ");
                Cell cell = this.cells[y][x];
                sb.append("[").append(cell != null ? cell.getValue() : " ").append("]");
                sb.append(" ");
            }
            sb.append("|\n");
        }
        return sb.toString();
    }

    public Cell[][] getCells() {
        Cell[][] result = new Cell[size][size];
        for (int i = 0; i < size; i++) {
            result[i] = this.cells[i].clone();
        }
        return result;
    }

    int getSize() {
        return this.size;
    }

    boolean has(int i) {
        for (int y = 0; y < this.size; y++) {
            for (int x = 0; x < this.size; x++) {
                if(this.cells[y][x] != null && this.cells[y][x].getValue() == i) return true;
            }
        }
        return false;
    }
}
