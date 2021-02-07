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

        int minDistance = Math.abs(bCoordinateX - aCoordinateX) + Math.abs(bCoordinateY - aCoordinateY);
        System.out.println((availableCharge % 2 == minDistance % 2) && availableCharge >= minDistance ? "Y" : "N");
    }
}
