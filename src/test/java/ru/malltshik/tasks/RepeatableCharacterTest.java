package ru.malltshik.tasks;

import org.junit.Test;

import static java.lang.System.*;
import static org.junit.Assert.*;

public class RepeatableCharacterTest {

    @Test
    public void findRepeatableCharacter() throws Exception {
        long start = nanoTime();
        assertEquals(RepeatableCharacter.findRepeatableCharacter("ADSFAFDKE"), "A");
        assertEquals(RepeatableCharacter.findRepeatableCharacter("ABCDEBFG"), "B");
        assertEquals(RepeatableCharacter.findRepeatableCharacter("LBCBADGC"), "B");
        assertNull(RepeatableCharacter.findRepeatableCharacter("ABCDEFG"));
        System.out.println(String.format("Time resul of test: %sns", nanoTime() - start));
    }

    @Test
    public void quickFindRepeatableCharacter() throws Exception {
        long start = nanoTime();
        assertEquals(RepeatableCharacter.quickFindRepeatableCharacter("ADSFAFDKE"), "A");
        assertEquals(RepeatableCharacter.quickFindRepeatableCharacter("ABCDEBFG"), "B");
        assertEquals(RepeatableCharacter.quickFindRepeatableCharacter("LBCBADGC"), "B");
        assertNull(RepeatableCharacter.quickFindRepeatableCharacter("ABCDEFG"));
        System.out.println(String.format("Time resul of test: %sns", nanoTime() - start));
    }

}