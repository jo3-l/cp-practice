package ccc.ccc2020;

import java.util.Scanner;

public class J3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

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
