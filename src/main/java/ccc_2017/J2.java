package ccc_2017;

import java.util.Scanner;

public class J2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int shiftCount = scanner.nextInt();

        // N + N * 10 + N * 100 ... = N(1 + 10 + 100 + ...)
        // This is equivalent to N multiplied by a geometric series where the first term is 1 and the ratio is 10.
        // Using the formula for obtaining the sum of a infinite geometric series, we get:
        //
        // sum = (1 - 10 ^ n) / (1 - 10) = (1 - 10 ^ n) / -9
        // where _n_ is the number of terms.
        int sum = (int) (1 - Math.pow(10, shiftCount + 1)) / -9;

        System.out.println(sum * num);
    }
}
