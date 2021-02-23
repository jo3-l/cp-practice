package ccc2021;

import java.util.Scanner;

public class S1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int woodCount = scanner.nextInt();

        // +1 because there are N+1 inputs describing the heights.
        int[] woodHeights = new int[woodCount + 1];
        int[] woodWidths = new int[woodCount];
        for (int i = 0; i < woodCount + 1; i++) woodHeights[i] = scanner.nextInt();
        for (int i = 0; i < woodCount; i++) woodWidths[i] = scanner.nextInt();

        double total = 0;
        for (int i = 0; i < woodCount; i++) {
            float left = woodHeights[i];
            int right = woodHeights[i + 1];
            int width = woodWidths[i];

            total += ((left + right) * width) / 2;
        }
        System.out.println((double) Math.round(total * 10) / 10);
    }
}
