package binarysearch;

public class MakingChangeSequel {
    public int solve(int[] denominations, int amount) {
        int[][] dp = new int[amount + 1][denominations.length];
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < denominations.length; j++) {
                dp[i][j] = Integer.MAX_VALUE;
                dp[i][j] = Math.min(
                        j > 0 ? dp[i][j - 1] : Integer.MAX_VALUE,
                        i >= denominations[j]
                                ? dp[i - denominations[j]][j] == Integer.MAX_VALUE
                                    ? Integer.MAX_VALUE
                                    : dp[i - denominations[j]][j] + 1
                                : Integer.MAX_VALUE
                );
            }
        }
        int v = dp[amount][denominations.length - 1];
        if (v == Integer.MAX_VALUE) return -1;
        return v;
    }
}
