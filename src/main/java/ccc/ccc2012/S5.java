package ccc.ccc2012;

import java.util.Scanner;

public class S5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt();
        int c = sc.nextInt();
        boolean[][] cats = new boolean[r][c];
        int k = sc.nextInt();
        while (k-- > 0) {
            cats[sc.nextInt() - 1][sc.nextInt() - 1] = true;
        }

        int[][] dp = new int[r][c];
        dp[0][0] = 1;
        dp[0][1] = 1;
        dp[1][0] = 1;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (cats[i][j] || (i == 0 && j == 0) || (i == 0 && j == 1) || (i == 1 && j == 0)) continue;
                dp[i][j] = (j >= 1 && !cats[i][j - 1] ? dp[i][j - 1] : 0) + (i >= 1 && !cats[i - 1][j] ? dp[i - 1][j] : 0);
            }
        }
        System.out.println(dp[r - 1][c - 1]);
    }
}
