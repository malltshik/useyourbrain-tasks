package ru.malltshik.tasks;

import org.junit.Test;

import static org.junit.Assert.*;

public class StairsToTheTopTest {


    @Test
    public void countSteps() throws Exception {
        int paths = StairsToTheTop.countSteps(4, new int[]{1,2,3,4});
        assertEquals(paths, 8);
    }

}