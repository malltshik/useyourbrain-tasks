package ru.malltshik.tasks.games.kalah.models;

import java.util.ArrayList;
import java.util.Random;

public class Field {

    private final ArrayList<Integer> pits = new ArrayList<>(14);

    //true - first player; false - second player;
    private boolean isFirstPlayer;

    public Field() {
        for (int i = 0; i <= 13; i++) {
            if (i == 6 || i == 13) pits.add(0);
            else pits.add(6);
        }
        isFirstPlayer = new Random().nextBoolean();
    }

    public void move(int index) {
        // pass turn if not allowed
        if (!isAllowedIndex(index) || pits.get(index) == 0) return;
        // count of stones in pit
        Integer count = pits.get(index);
        // set count to 0 in current pit
        pits.set(index, 0);
        // put each stone to the next pits;
        int lastIndex = 0;
        for (; count > 0; count--) {
            if (index == 13) index = -1;
            // pass through enemies kalah without setting one more stone
            if (!(isFirstPlayer && index + 1 == 13) && !(!isFirstPlayer && index + 1 == 6)) {
                lastIndex = index++;
                pits.set(lastIndex, pits.get(lastIndex) + 1);
            }
        }
        stillStones(lastIndex);
        setNextPlayerTurn(lastIndex);
        // TODO  check win statement
    }

    /**
     * If last turn stone has been set to empty friendly pit, player could take all stones from against pit
     *
     * @param lastIndex last turn index
     */
    private void stillStones(int lastIndex) {
        Integer count = this.pits.get(lastIndex);
        if (count != 1 || !isCurrentPlayersPit(lastIndex)) return;
        // TODO implement this function
        // if last at index 0 -> still stones from 12
        // if last at index 1 -> still stones from 11
        // ...
        // if last at index 12 -> still stones from 0
    }

    /**
     * Check next player turn
     * <p>
     * If last stone has been set in friendly kalah, player's will repeat
     *
     * @param lastIndex last turn index
     */
    private void setNextPlayerTurn(int lastIndex) {
        if ((isFirstPlayer && lastIndex != 6) || (!isFirstPlayer && lastIndex != 13))
            isFirstPlayer = !isFirstPlayer;
    }

    /**
     * [0-5] - first player
     * [7-12] - second player
     * [6, 13] - kalahs pits not allowed to set stones
     *
     * @param index target index
     * @return check statement result
     */
    private boolean isAllowedIndex(int index) {
        return !(index < 0 || index == 6 || index >= 13) && isCurrentPlayersPit(index);
    }


    private boolean isCurrentPlayersPit(int index) {
        return isPlayersPit(index, isFirstPlayer);
    }

    private boolean isPlayersPit(int index, boolean isFirstPlayer) {
        return (isFirstPlayer && index <= 5 && index >= 0) || (!isFirstPlayer && index <= 12 && index >= 7);
    }

    @Override
    public String toString() {
        return this.pits.toString();
    }

}


