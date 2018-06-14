package ru.malltshik.tasks.games.kalah.models;

import java.util.ArrayList;

public class Field {

    private final ArrayList<Integer> pits = new ArrayList<>(14);

    Field() {
        for (int i = 0; i <= 13; i++) {
            if (i == 6 || i == 13) pits.add(0);
            else pits.add(6);
        }
    }

    public void move(int index) {
        if(!isAllowedIndex(index) || pits.get(index) == 0) return;
        Integer count = pits.get(index); pits.set(index, 0);
        for (;count > 0; count--) {
            if(index == 13) index = -1;
            pits.set(index + 1, pits.get(index + 1) + 1);
            index++;
        }
    }

    private boolean isAllowedIndex(int index) {
        return !(index < 0 || index == 6 || index >= 13);
    }

    @Override
    public String toString() {
        return this.pits.toString();
    }

}


