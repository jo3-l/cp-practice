package binarysearch;

// TODO: This is broken, but I have no idea why. Asked in the #coding-questions channel on binarysearch; hopefully someone will help : )
public class MaximumProductPathInMatrix {
    public int solve(int[][] matrix) {
        int MOD = 1_000_000_007;

        int[][] minDp = new int[matrix.length][matrix[0].length];
        int[][] maxDp = new int[matrix.length][matrix[0].length];
        minDp[0][0] = maxDp[0][0] = matrix[0][0];
        for (int i = 0; i < matrix.length; i++) {
            int[] row = matrix[i];
            for (int j = 0; j < row.length; j++) {
                if (i == 0 && j == 0) continue;
                int minV = Integer.MAX_VALUE;
                int maxV = Integer.MIN_VALUE;
                if (i > 0) {
                    minV = Math.min(minV, minDp[i - 1][j] * row[j]);
                    minV = Math.min(minV, maxDp[i - 1][j] * row[j]);
                    maxV = Math.max(maxV, minDp[i - 1][j] * row[j]);
                    maxV = Math.max(maxV, maxDp[i - 1][j] * row[j]);
                }
                if (j > 0) {
                    minV = Math.min(minV, minDp[i][j - 1] * row[j]);
                    minV = Math.min(minV, maxDp[i][j - 1] * row[j]);
                    maxV = Math.max(maxV, minDp[i][j - 1] * row[j]);
                    maxV = Math.max(maxV, maxDp[i][j - 1] * row[j]);
                }

                minDp[i][j] = minV % MOD;
                maxDp[i][j] = maxV % MOD;
            }
        }

        int val = maxDp[matrix.length - 1][matrix[0].length - 1];
        if (val < 0) return -1;
        return val % MOD;
    }
}
