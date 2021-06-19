package binarysearch;

public class RodCutting {
    private int[][] dp;

    public int solve(int[] prices, int n) {
        dp = new int[n + 1][prices.length];
        return go(prices, n, 0);
    }

    private int go(int[] prices, int remaining, int i) {
        if (i == prices.length) return 0;
        if (dp[remaining][i] != 0) return dp[remaining][i];

        int size = i + 1;
        int price = prices[i];
        return dp[remaining][i] = Math.max(
                Math.max(
                        // skip this size
                        go(prices, remaining, i + 1),
                        // cut off cur size from rod and stay here
                        remaining - size >= 0
                                ? price + go(prices, remaining - size, i)
                                : -1
                ),
                // cut off cur size from rod and go onto next
                remaining - size >= 0
                        ? price + go(prices, remaining - size, i + 1)
                        : -1
        );
    }
}
