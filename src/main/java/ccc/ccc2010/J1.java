package ccc.ccc2010;

import java.util.Scanner;

public class J1 {
    public static void main(String[] args) {
        int k = 5; // Number of fingers on each hand.

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        if (n <= k) System.out.println(Math.floorDiv(n, 2) + 1);
        else System.out.println(Math.floorDiv(2 * k - n, 2) + 1);
    }
}
