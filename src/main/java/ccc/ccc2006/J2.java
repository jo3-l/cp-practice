package ccc.ccc2006;

import java.util.Scanner;

public class J2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int t = 0;
        for (int i = 1; i <= Math.min(m, 10); i++) {
            for (int j = 1; j <= Math.min(n, 10); j++) {
                if (i + j == 10) t++;
            }
        }

        if (t == 1) {
            System.out.println("There is 1 way to get the sum 10.");
        } else {
            System.out.println("There are " + t + " ways to get the sum 10.");
        }
    }
}
