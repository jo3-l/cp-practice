package binarysearch;

public class AManiacalWalk {
    public int solve(int length, int n) {
        final long MOD = (long) 1e9 + 7;
        long[][] dp = new long[n + 1][length];
        dp[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < length; j++) {
                dp[i][j] = (j < length - 1 ? dp[i - 1][j + 1] % MOD : 0)
                        + (j > 0 ? dp[i - 1][j - 1] % MOD : 0)
                        + (dp[i - 1][j] % MOD);
                dp[i][j] %= MOD;
            }
        }
        return (int) (dp[n][0] % MOD);
    }
}
