package ccc.ccc2009;

import java.util.Scanner;

public class S1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int lo = (int) Math.pow(a, (double) 1 / 3);
        int hi = (int) Math.ceil(Math.pow(b, (double) 1/ 3));
        int j = 0;
        for (int x = lo; x <= hi; x++) {
            int p3 = x * x * x;
            if (p3 < a) continue;
            if (p3 > b) break;
            int n = (int) Math.sqrt(p3);
            if (n * n == p3) j++;
        }
        System.out.println(j);
    }
}
