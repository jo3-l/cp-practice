package binarysearch;

public class ParticularPaths {
    public int solve(int[][] matrix, int k) {
        final int MOD = (int) 1e9 + 7;
        int R = matrix.length;
        int C = matrix[0].length;
        long[][][] dp = new long[R][C][k + 1];
        dp[R - 1][C - 1][matrix[R - 1][C - 1]] = 1;
        for (int i = R - 1; i >= 0; i--) {
            for (int j = C - 1; j >= 0; j--) {
                if (i == R - 1 && j == C - 1) continue;
                for (int m = 0; m <= k; m++) {
                    int s = m - matrix[i][j];
                    if (s < 0) continue;
                    dp[i][j][m] = (i < R - 1 ? dp[i + 1][j][s] : 0) + (j < C - 1 ? dp[i][j + 1][s] : 0);
                    dp[i][j][m] %= MOD;
                }
            }
        }
        return (int) (dp[0][0][k] % MOD);
    }
}
