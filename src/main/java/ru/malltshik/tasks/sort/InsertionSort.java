package ru.malltshik.tasks.sort;

import java.util.Arrays;

/**
 * Insertion sort N^2/2 comparing and N^2/2 moving
 * In the best case N-1 coparing and 0 moving
 *
 * Good for almost sorted input data
 */
public class InsertionSort {
    public static int[] sort(int[] a) {
        int N = a.length;
        for (int i = 1; i < N; i++) {
            for (int j = i; j > 0 && a[j] < a[j - 1]; j--) {
                int next = a[j];
                if (next < a[j - 1]) {
                    a[j] = a[j - 1];
                    a[j - 1] = next;
                }
            }
        }
        return a;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(sort(new int[]{9,8,7,6,5,4,3,2,1})));
    }
}
