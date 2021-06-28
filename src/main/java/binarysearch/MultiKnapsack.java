package binarysearch;

public class MultiKnapsack {
    private int[][][] dp;

    public int solve(int[] weights, int[] values, int capacity, int count) {
        dp = new int[values.length][capacity + 1][count + 1];
        return go(weights, values, 0, capacity, count);
    }

    private int go(int[] weights, int[] values, int idx, int remainingCapacity, int remainingCount) {
        if (remainingCount == 0 || remainingCapacity <= 0 || idx == values.length) return 0;
        if (dp[idx][remainingCapacity][remainingCount] != 0) return dp[idx][remainingCapacity][remainingCount];
        boolean canTake = remainingCapacity >= weights[idx];
        return dp[idx][remainingCapacity][remainingCount] = Math.max(
                go(weights, values, idx + 1, remainingCapacity, remainingCount),
                canTake
                        ? values[idx] + go(weights, values, idx + 1, remainingCapacity - weights[idx], remainingCount - 1)
                        : Integer.MIN_VALUE
        );
    }
}
