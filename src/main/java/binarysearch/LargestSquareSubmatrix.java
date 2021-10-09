package binarysearch;

public class LargestSquareSubmatrix {
    public int solve(int[][] matrix) {
        int[][] dp = new int[matrix.length][matrix[0].length]; // dp[i][j] = largest square w/ lower right cell (i, j)
        System.arraycopy(matrix[0], 0, dp[0], 0, dp[0].length);
        for (int i = 0; i < dp.length; i++) dp[i][0] = matrix[i][0];
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (matrix[i][j] == 1) {
                    dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1])) + 1;
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        int m = 0;
        for (int[] row : dp) {
            for (int i : row) m = Math.max(m, i);
        }
        return m * m;
    }
}
