package ru.malltshik.tasks;

/**
 * This problem was asked by Facebook.
 * <p>
 * Given a array of numbers representing the stock prices of a company in chronological order,
 * write a function that calculates the maximum profit you could have made from buying and selling that stock once.
 * You must buy before you can sell it.
 * <p>
 * For example, given [9, 11, 8, 5, 7, 10], you should return 5, since you could buy the stock at 5 dollars and sell it at 10 dollars.
 */
public class DailyTask47 {

    // First idea solution with O(N^2) time complexity
    // I guess there is should be a bit more faster solution
    static int slowSolution(int[] input) {
        int[] indexToBenefit = new int[] {0, Integer.MIN_VALUE};
        int N = input.length;
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                int benefit = input[j] - input[i];
                if(indexToBenefit[1] < benefit) {
                    indexToBenefit[0] = i;
                    indexToBenefit[1] = benefit;
                }
            }
        }
        return input[indexToBenefit[0]];
    }


    public static void main(String[] args) {
        int[] input = {5, 9, 8, 7, 6, 5};
        if (slowSolution(input) != 5) System.exit(42);
    }

}
