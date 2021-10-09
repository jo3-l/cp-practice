package binarysearch;

public class DiceThrow {
    private int[][] dp;

    public int solve(int n, int faces, int total) {
        dp = new int[n + 1][total + 1];
        return go(n, faces, total);
    }

    private int go(int n, int faces, int total) {
        if (total == 0 && n == 0) return 1;
        if (n <= 0 || total < 0 || faces * n < total || n > total) return 0;
        if (dp[n][total] != 0) return dp[n][total];
        int ways = 0;
        for (int i = 1; i <= faces; i++) {
            ways += go(n - 1, faces, total - i);
            ways %= 1000000007;
        }
        return dp[n][total] = ways;
    }
}
