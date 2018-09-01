package ru.malltshik.tasks;

/**
 * Given an array of integers, find the first missing positive integer in linear time and constant space.
 * In other words, find the lowest positive integer that does not exist in the array.
 * The array can contain duplicates and negative numbers as well.
 *
 * For example, the input [2, 4, -1, 1] should give 3. The input [1, 2, 0] should give 3.
 *
 */
public class DailyCodingProblem4 {

    // TODO this implementation is quasilinear O(N log N)
    // But linear is possible. Think
    public static int findFirstPositive(int[] source) {
        int N = source.length;
        int[] positives = new int[N];
        for (int i : source) {
            if (N >= i && i > 0) positives[i - 1] = i;
        }
        for (int i = 0; i < N; i++) {
            if (positives[i] != i + 1) return i + 1;
        }
        return positives[N - 1] + 1;
    }

}
