package ru.malltshik.tasks;

import org.junit.Test;

import static org.junit.Assert.*;

public class HopTowersTest {
    @Test
    public void isHoppable() throws Exception {

        assertTrue(HopTowers.isHoppable(new int[]{1, 4, 0, 0, 0, 5}));
        assertTrue(HopTowers.isHoppable(new int[]{4, 2, 0, 0, 2, 0}));
        assertTrue(HopTowers.isHoppable(new int[]{1, 1, 1, 1, 1, 1}));
        assertTrue(HopTowers.isHoppable(new int[]{7, 1, 1, 1, 1, 1}));
        assertTrue(HopTowers.isHoppable(new int[]{7, 1, 1, 1, 1, 1}));
        assertTrue(HopTowers.isHoppable(new int[]{2, 0, 1, 3, 0, 0}));


        assertFalse(HopTowers.isHoppable(new int[]{1, 3, 0, 0, 0, 5}));
        assertFalse(HopTowers.isHoppable(new int[]{1, 3, 1, 0, 0, 10}));
        assertFalse(HopTowers.isHoppable(new int[]{1, 3, 0, 0, 0, 5}));
        assertFalse(HopTowers.isHoppable(new int[]{0, 3, 10, 2, 3, 5}));
        assertFalse(HopTowers.isHoppable(new int[]{1, 1, 1, 1, 0, 1}));
        assertFalse(HopTowers.isHoppable(new int[]{5, 0, 0, 0, 0, 0}));
    }
}