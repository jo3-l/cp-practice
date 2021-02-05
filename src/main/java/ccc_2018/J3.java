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
            if (i != 0) sb.append("\n");
            for (int j = 0; j < 5; j++) {
                int distance = calculator.getDistanceBetween(i, j);
                if (j != 0) sb.append(" ");
                sb.append(distance);
            }
        }

        System.out.println(sb.toString());
    }

    private static class DistanceCalculator {
        private final int[] distanceArray;
        private int[][] distanceCache = new int[5][5];

        public DistanceCalculator(int[] distanceArray) {
            this.distanceArray = distanceArray;
        }

        public int getDistanceBetween(int a, int b) {
            if (a == b) return 0;
            int min = Math.min(a, b);
            int max = Math.max(a, b);

            int cachedValue = distanceCache[min][max];
            if (cachedValue == 0) {
                // No value in the cache, so compute it.
                int value = 0;
                for (int i = min; i < max; i++) value += distanceArray[i];
                distanceCache[min][max] = value;
                return value;
            }

            return cachedValue;
        }
    }
}
