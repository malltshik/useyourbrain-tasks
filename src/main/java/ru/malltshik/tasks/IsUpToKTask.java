package ru.malltshik.tasks;

import java.util.Arrays;
import java.util.HashSet;

/**
 * This problem was recently asked by Google.
 * Given a list of numbers and a number k, return whether any two numbers from the list add up to k.
 * For example, given [10, 15, 3, 7] and k of 17, return true since 10 + 7 is 17.
 * Bonus: Can you do this in one pass?
 */
public class IsUpToKTask {

    static boolean isUpToKWithSort(int[] a, int k) {
        Arrays.sort(a);
        int N = a.length;
        int i = 0;
        for (int j = N - 1; i < j; ) {
            int sum = a[i] + a[j];
            if (sum == k) return true;
            else if (sum < k) i++;
            else j--;
        }
        return false;
    }

    static boolean isUpToKWithoutSort(int[] a, int k) {
        int N = a.length;
        HashSet<Integer> complements = new HashSet<>(N);
        for (int i = 0; i < N; i++) {
            int complement = k - a[i];
            if (complements.contains(complement)) return true;
            else complements.add(a[i]);
        }
        return false;
    }

    public static void main(String[] args) {
        timer(() -> System.out.println(isUpToKWithSort(randomArrayWithSize(10), 18)));
        timer(() -> System.out.println(isUpToKWithoutSort(randomArrayWithSize(10), 18)));
    }


    private static int[] randomArrayWithSize(int size) {
        int[] list = new int[size];
        for (int i = 0; i < size; i++) {
            int n = (int) (Math.random() * 9 + 1);
            list[i] = n;
        }
        return list;
    }

    private static void timer(Runnable runnable) {
        long l = System.nanoTime();
        runnable.run();
        System.out.println(String.format("Task %s spent %s ms.", runnable, (System.nanoTime() - l) / 10000));
    }

}
