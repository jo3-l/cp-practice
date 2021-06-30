package ccc.ccc2005;

import java.util.Scanner;

public class J2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int lo = sc.nextInt();
        int hi = sc.nextInt();
        int n = 0;
        outer: for (int i = lo; i <= hi; i++) {
            int divisors = 2 /* 1 and itself */;
            for (int j = 2; j * j <= i; j++) {
                if (i % j == 0) {
                    divisors++;
                    int other = i / j;
                    if (other != j) divisors++;
                    if (divisors > 4) continue outer;
                }
            }

            if (divisors == 4) n++;
        }
        System.out.println("The number of RSA numbers between " + lo + " and " + hi + " is " + n);
    }
}
