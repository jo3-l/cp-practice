package ccc.ccc2004;

import java.util.Scanner;

public class J3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        String[] x = new String[n];
        for (int i = 0; i < n; i++) x[i] = sc.next();
        String[] y = new String[m];
        for (int i = 0; i < m; i++) y[i] = sc.next();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.println(x[i] + " as " + y[j]);
            }
        }
    }
}
