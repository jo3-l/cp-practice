package binarysearch;

public class PolyKnapsack {
    private int[][] dp;

    public int solve(int[] weights, int[] values, int capacity) {
        dp = new int[capacity + 1][weights.length];
        return go(weights, values, capacity, 0);
    }

    private int go(int[] weights, int[] values, int remaining, int i) {
        if (remaining == 0 || i == values.length) return 0;
        if (dp[remaining][i] != 0) return dp[remaining][i];
        int nextRem = remaining - weights[i];
        return dp[remaining][i] = Math.max(
                Math.max(
                        // skip this value and move on
                        go(weights, values, remaining, i + 1),
                        // take this value and move on
                        nextRem >= 0
                                ? values[i] + go(weights, values, nextRem, i + 1)
                                : Integer.MIN_VALUE
                ),
                // take this value and stay here
                nextRem >= 0
                        ? values[i] + go(weights, values, nextRem, i)
                        : Integer.MIN_VALUE
        );
    }
}
