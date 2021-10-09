package binarysearch;

import java.util.Arrays;

public class LargestSquareMatrixWithSameValue {
    public int solve(int[][] matrix) {
        int[][] dp = new int[matrix.length][matrix[0].length];
        Arrays.fill(dp[0], 1);
        for (int i = 0; i < matrix.length; i++) dp[i][0] = 1;
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[i].length; j++) {
                if (matrix[i][j] == matrix[i - 1][j] && matrix[i][j] == matrix[i][j - 1] && matrix[i][j] == matrix[i - 1][j - 1]) {
                    dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i - 1][j - 1], dp[i][j - 1])) + 1;
                } else {
                    dp[i][j] = 1;
                }
            }
        }
        int max = 0;
        for (int[] xs : dp) {
            for (int v : xs) max = Math.max(max, v);
        }
        return max;
    }
}
