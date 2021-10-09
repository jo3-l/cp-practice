package kattis;

import java.util.Scanner;

public class AboveAverage {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int i = 0; i < testCases; i++) {
            int classSize = scanner.nextInt();

            int[] scores = new int[classSize];
            int total = 0;
            for (int j = 0; j < classSize; j++) {
                int score = scanner.nextInt();
                scores[j] = score;
                total += score;
            }

            float average = (float) total / classSize;
            int aboveAverage = 0;
            for (int score : scores) {
                if (score > average) ++aboveAverage;
            }

            System.out.printf("%.3f%%\n", ((float) aboveAverage / classSize) * 100);
        }
    }
}
