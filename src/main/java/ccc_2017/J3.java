package ccc_2017;

import java.util.Scanner;

public class J3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] aCoordinateParts = scanner.nextLine().split(" ");
        int aCoordinateX = Integer.parseInt(aCoordinateParts[0]);
        int aCoordinateY = Integer.parseInt(aCoordinateParts[1]);

        String[] bCoordinateParts = scanner.nextLine().split(" ");
        int bCoordinateX = Integer.parseInt(bCoordinateParts[0]);
        int bCoordinateY = Integer.parseInt(bCoordinateParts[1]);

        int availableCharge = scanner.nextInt();

        // The minimum distance possible is the difference of the y-coordinates plus the difference of the two
        // x-coordinates. This occurs when we move in a straight line from the 
        int minDistance = Math.abs(bCoordinateX - aCoordinateX) + Math.abs(bCoordinateY - aCoordinateY);
        // We can then add any multiple of 2 to the minimum distance by doing, say, 2 U-turns in a row to go back
        // to where we originally started.
        System.out.println((availableCharge % 2 == minDistance % 2) && availableCharge >= minDistance ? "Y" : "N");
    }
}
