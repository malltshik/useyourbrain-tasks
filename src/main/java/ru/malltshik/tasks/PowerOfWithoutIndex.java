package ru.malltshik.tasks;

import java.util.Arrays;


/**
 * Given an array of integers, return a new array such that each element at index i of the new array
 * is the product of all the numbers in the original array except the one at i.
 *
 * For example, if our input was [1, 2, 3, 4, 5], the expected output would be [120, 60, 40, 30, 24].
 * If our input was [3, 2, 1], the expected output would be [2, 3, 6].
 *
 * Follow-up: what if you can't use division?
 *
 */
public class PowerOfWithoutIndex {

    // with division
    public static int[] withDivision(int[] source) {
        int N = source.length;
        int max = 1;
        int[] result = new int[N];
        for (int i : source) {
            max *= i;
        }
        for (int i = 0; i < N; i++) {
            result[i] = max / source[i];
        }
        return result;
    }

    // without division
    public static int[] withoutDivision(int[] source) {
        int N = source.length;
        int[] forward = new int[N];
        int[] backward = new int[N];
        int[] result = new int[N];
        for(int i = 0; i < N; i++) {
            if(i == 0) forward[i] = backward[i] = 1;
            else {
                forward[i] = source[i - 1] * forward[i - 1];
                backward[i] = source[N - i] * backward[i - 1];
            }
        }
        for (int i = 0; i < N; i++) {
            result[i] = forward[i] * backward[N - i - 1];
        }
        return result;
    }

    public static void main(String[] args) {
        assert Arrays.toString(withoutDivision(new int[]{1, 2, 3, 4, 5})).equals("[120, 60, 40, 30, 24]");
        assert Arrays.toString(withDivision(new int[]{1, 2, 3, 4, 5})).equals("[120, 60, 40, 30, 24]");
    }

}
