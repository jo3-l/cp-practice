package ccc.ccc2007;

import java.util.Scanner;

public class S1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while (n-- > 0) {
            int y = sc.nextInt();
            int m = sc.nextInt();
            int d = sc.nextInt();
            if (y != 1989) {
                System.out.println(y < 1989 ? "Yes" : "No");
                continue;
            }
            if (m != 2) {
                System.out.println(m < 2 ? "Yes" : "No");
                continue;
            }
            System.out.println(d <= 27 ? "Yes" : "No");
        }
    }
}
