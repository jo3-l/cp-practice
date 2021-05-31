package binarysearch;

public class FlightOfStairs {
    public int solve(int n) {
        int M = 1_000_000_007;

        int[] dp = new int[Math.max(n + 1, 3)];
        dp[1] = 1; // 1 way to climb up 1 step
        dp[2] = 2; // 1 new path (0 -> 2 steps)
        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % M;
        }

        return dp[n];
    }
}
