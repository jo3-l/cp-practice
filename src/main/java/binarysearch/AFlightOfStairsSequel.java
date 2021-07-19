package binarysearch;

public class AFlightOfStairsSequel {
    public int solve(int n, int k) {
        if (n < 3) return (new int[]{1, 1, 2})[n];
        int[][] dp = new int[n + 1][k + 1];
        dp[0][k] = 1;
        dp[1][k] = 1;
        dp[2][k] = 2;
        for (int i = 3; i <= n; i++) {
            for (int j = 0; j <= k; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i - 2][j] + (j != k ? dp[i - 3][j + 1] : 0);
            }
        }
        int x = 0;
        for (int v : dp[n]) x += v;
        return x;
    }
}
