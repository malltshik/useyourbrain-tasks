package ru.malltshik.tasks.sort;


import java.util.Arrays;

/**
 * Section sort O(~N^2/2) comparing operation and N moving operation
 *
 * This sort algorithm doesn't depend on input data. It works slow even with almost sorted data
 */
public class SelectionSort {

    private static int[] sort(int[] a) {
        int N = a.length;
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                int next = a[j];
                if (next < a[i]) {
                    a[j] = a[i];
                    a[i] = next;
                }
                System.out.println(Arrays.toString(a));
            }
        }
        return a;
    }
}
