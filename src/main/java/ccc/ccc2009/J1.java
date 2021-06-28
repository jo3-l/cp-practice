package ccc.ccc2009;

import java.util.Scanner;

public class J1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] digits = new int[]{9, 7, 8, 0, 9, 2, 1, 4, 1, 8, sc.nextInt(), sc.nextInt(), sc.nextInt()};
        int[] multipliers = new int[]{1, 3};
        int sum = 0;
        for (int i = 0; i < digits.length; i++) sum += multipliers[i & 1] * digits[i];
        System.out.println("The 1-3-sum is " + sum);
    }
}
