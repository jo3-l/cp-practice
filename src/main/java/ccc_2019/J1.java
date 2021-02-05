package ccc_2019;

import java.util.Scanner;

public class J1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int threePointApples = scanner.nextInt();
        int twoPointApples = scanner.nextInt();
        int onePointApples = scanner.nextInt();
        int applesScore = 3 * threePointApples + 2 * twoPointApples + onePointApples;

        int threePointBananas = scanner.nextInt();
        int twoPointBananas = scanner.nextInt();
        int onePointBananas = scanner.nextInt();
        int bananasScore = 3 * threePointBananas + 2 * twoPointBananas + onePointBananas;

        if (applesScore > bananasScore) System.out.println("A");
        else if (bananasScore == applesScore) System.out.println("T");
        else System.out.println("B");
    }
}
