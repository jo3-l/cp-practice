package ccc.ccc2013;

import java.util.Scanner;

public class J3S1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int Y = sc.nextInt();
        Y++;
        while (!hasDistinctDigits(Y)) Y++;
        System.out.println(Y);
    }

    private static boolean hasDistinctDigits(int n) {
        int b = 0;
        while (n >= 10) {
            int r = n % 10;
            int bb = 1 << r;
            if ((b & bb) != 0) return false;
            b |= bb;
            n /= 10;
        }
        return (b & (1 << n)) == 0;
    }
}
