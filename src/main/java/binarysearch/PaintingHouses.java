package binarysearch;

public class PaintingHouses {
    public int solve(int[][] matrix) {
        int N = matrix.length;
        int K = matrix[0].length;
        int[][] dp = new int[N][K];
        System.arraycopy(matrix[0], 0, dp[0], 0, K);
        for (int i = 1; i < N; i++) {
            for (int k = 0; k < K; k++) {
                int prev = Integer.MAX_VALUE;
                for (int j = 0; j < K; j++) {
                    if (j != k) prev = Math.min(prev, dp[i - 1][j]);
                }
                dp[i][k] = prev + matrix[i][k];
            }
        }
        int m = Integer.MAX_VALUE;
        for (int v : dp[N - 1]) m = Math.min(m, v);
        return m;
    }
}
