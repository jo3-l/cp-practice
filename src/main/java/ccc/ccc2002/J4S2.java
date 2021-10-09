package ccc.ccc2002;

import java.util.Scanner;

public class J4S2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int d = sc.nextInt();
        int w = n / d, f = n % d;
        if (f != 0) {
            int g = gcd(f, d);
            f /= g;
            d /= g;
            if (w != 0) System.out.print(w + " ");
            System.out.println(f + "/" + d);
        } else {
            System.out.println(w);
        }
    }

    private static int gcd(int a, int b) {
        while (b > 0) {
            int t = b;
            b = a % b;
            a = t;
        }
        return a;
    }
}
