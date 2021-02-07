package ccc_2018;

import java.util.Scanner;

public class J3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] distanceArray = new int[4];
        for (int i = 0; i < 4; i++) distanceArray[i] = scanner.nextInt();

        DistanceCalculator calculator = new DistanceCalculator(distanceArray);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            // Append a newline if it isn't the first iteration.
            if (i != 0) sb.append("\n");
            for (int j = 0; j < 5; j++) {
                int distance = calculator.getDistanceBetween(i, j);
                // Append a space if it isn't the first iteration.
                if (j != 0) sb.append(" ");
                sb.append(distance);
            }
        }

        System.out.println(sb.toString());
    }

    private static class DistanceCalculator {
        private final int[] distanceArray;
        // Cache of distances between cities, so we don't perform the computation every time.
        private int[][] distanceCache = new int[5][5];

        public DistanceCalculator(int[] distanceArray) {
            this.distanceArray = distanceArray;
        }

        public int getDistanceBetween(int a, int b) {
            if (a == b) return 0;
            // We want a to be the smaller integer and b to be the larger one, so swap them if necessary.
            if (a > b) {
                int tmp = a;
                a = b;
                b = tmp;
            }

            int cachedValue = distanceCache[a][b];
            if (cachedValue == 0) {
                // No value in the cache, so compute it and cache it.
                int value = 0;
                for (int i = a; i < b; i++) value += distanceArray[i];
                distanceCache[a][b] = value;
                return value;
            }

            return cachedValue;
        }
    }
}
