package cses;

import java.util.Scanner;

public class WeirdAlgorithm {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextInt();
        System.out.println(n);
        if (n == 1) return;
        while ((n = next(n)) != 1) System.out.println(n);
        System.out.println(1);
    }

    private static long next(long n) {
        if ((n & 1) == 0) return n >> 1;
        return (n * 3) + 1;
    }
}
