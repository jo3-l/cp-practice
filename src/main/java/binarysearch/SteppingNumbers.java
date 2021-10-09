package binarysearch;

import java.util.Arrays;

public class SteppingNumbers {
    public int solve(int n) {
        final int MOD = (int) 1e9 + 7;
        if (n == 1) return 10;
        int[][] dp = new int[n + 1][10];
        Arrays.fill(dp[1], 1);
        dp[1][0] = 0;
        for (int i = 2; i <= n; i++) {
            for (int l = 0; l <= 9; l++) {
                dp[i][l] = ((l > 0 ? dp[i - 1][l - 1] % MOD : 0) + (l < 9 ? dp[i - 1][l + 1] % MOD : 0)) % MOD;
            }
        }
        long s = 0;
        for (int i = 0; i <= 9; i++) s = (s % MOD) + (dp[n][i] % MOD) % MOD;
        return (int) s % MOD;
    }
}
