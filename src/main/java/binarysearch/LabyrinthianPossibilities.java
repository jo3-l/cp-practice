package binarysearch;

public class LabyrinthianPossibilities {
    public int solve(int[][] matrix) {
        final long MOD = (long) 1e9 + 7;
        int R = matrix.length;
        int C = matrix[0].length;
        long[][] dp = new long[R][C];
        dp[0][0] = matrix[0][0] = 1;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (matrix[i][j] == 1) continue;
                dp[i][j] = (i > 0 ? dp[i - 1][j] : 0) + (j > 0 ? dp[i][j - 1] : 0);
                dp[i][j] %= MOD;
            }
        }
        return (int) (dp[R - 1][C - 1] % MOD);
    }
}
