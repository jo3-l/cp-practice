package binarysearch;

public class Knapsack01 {
    private int[][] dp;

    public int solve(int[] weights, int[] values, int capacity) {
        dp = new int[weights.length + 1][capacity + 1];
        return run(weights, values, capacity, weights.length - 1);
    }

    private int run(int[] weights, int[] values, int capacity, int i) {
        if (i == -1 || capacity == 0) return 0;
        if (dp[i][capacity] != 0) return dp[i][capacity];

        int weight = weights[i];
        int value = values[i];

        if (capacity < weight) return dp[i][capacity] = run(weights, values, capacity, i - 1);
        return dp[i][capacity] = Math.max(
                value + run(weights, values, capacity - weight, i - 1),
                run(weights, values, capacity, i - 1)
        );
    }
}
