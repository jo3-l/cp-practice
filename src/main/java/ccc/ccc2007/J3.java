package ccc.ccc2007;

import java.util.Scanner;

public class J3 {
    public static void main(String[] args) {
        int[] amts = {0, 100, 500, 1000, 5000, 10_000, 25_000, 50_000, 100_000, 500_000, 1_000_000};
        int all = 0;
        for (int a : amts) all += a;

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int rem = all;
        for (int i = 0; i < N; i++) rem -= amts[sc.nextInt()];
        double avg = rem / (10d - N);
        System.out.println(sc.nextInt() > avg ? "deal" : "no deal");
    }
}
