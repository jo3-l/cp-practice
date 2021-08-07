package binarysearch;

public class PerfectSquares {
    public int solve(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 1; i <= n; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i - j * j] + 1, dp[i]);
            }
        }
        return dp[n];
    }
}
