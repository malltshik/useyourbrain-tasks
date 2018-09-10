package ru.malltshik.tasks;

/**
 * There exists a staircase with N steps, and you can climb up either 1 or 2 steps at a time. Given N, write a function that returns the number of unique ways you can climb the staircase. The order of the steps matters.
 * <p>
 * For example, if N is 4, then there are 5 unique ways:
 * <p>
 * 1, 1, 1, 1
 * 2, 1, 1
 * 1, 2, 1
 * 1, 1, 2
 * 2, 2
 */
public class StaircaseUniqueWays {

    private static int getWays(int N) {
        int a = 1, b = 2, c;
        for (int i = 1; i < N; i++) {c = a + b; a = b; b = c;}
        return a;
    }

    public static void main(String[] args) throws Exception {
        if(getWays(7) != 21) throw new Exception("Test failed");
        if(getWays(6) != 13) throw new Exception("Test failed");
        System.out.println("OK");
    }

}
