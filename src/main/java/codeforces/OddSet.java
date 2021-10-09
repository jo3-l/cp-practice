package codeforces;

import java.util.Scanner;

public class OddSet {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int even = 0;
            int odd = 0;
            while (n-- > 0) {
                int v0 = sc.nextInt();
                int v1 = sc.nextInt();
                if ((v0 & 1) == 0) even++;
                else odd++;
                if ((v1 & 1) == 0) even++;
                else odd++;
            }

            System.out.println(odd == even ? "Yes" : "No");
        }
    }
}
