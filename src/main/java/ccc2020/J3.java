package ccc2020;

import java.util.Scanner;

public class J3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // All this question is is getting the maximum and minimum (x, y) coordinates from the set of points given and then
        // using the maximum (x, y) coordinates as the top right corner and the minimum (x, y) coordinates as the bottom
        // left corner. Of course, we have ot add/subtract 1 to make sure points on the edge fit. Otherwise, that's
        // essentially it for this question.

        int maxY = -1;
        int minY = 101;
        int minX = 101;
        int maxX = -1;

        int drops = scanner.nextInt();
        scanner.skip("\n");
        for (int i = 0; i < drops; i++) {
            String[] parts = scanner.nextLine().split(",");
            int currentX = Integer.parseInt(parts[0]);
            int currentY = Integer.parseInt(parts[1]);

            if (currentX > maxX) maxX = currentX;
            if (currentX < minX) minX = currentX;
            if (currentY > maxY) maxY = currentY;
            if (currentY < minY) minY = currentY;
        }

        // -1 and +1 because points on the grid are not technically inside according to the problem specification.
        System.out.printf("%d,%d\n%d,%d", minX - 1, minY - 1, maxX + 1, maxY + 1);
    }
}
