package binarysearch;

public class MinimumDroppingPathSum {
    public int solve(int[][] matrix) {
        int R = matrix.length;
        int C = matrix[0].length;

        int min = Integer.MAX_VALUE;
        int minCol = -1;
        int secondMin = Integer.MAX_VALUE;
        for (int j = 0; j < C; j++) {
            if (matrix[0][j] <= min) {
                secondMin = min;
                min = matrix[0][j];
                minCol = j;
            } else if (matrix[0][j] < secondMin) {
                secondMin = matrix[0][j];
            }
        }

        for (int i = 1; i < R; i++) {
            int nextMin = Integer.MAX_VALUE;
            int nextMinCol = -1;
            int nextSecondMin = Integer.MAX_VALUE;
            for (int j = 0; j < C; j++) {
                int lastRowMin = minCol == j ? secondMin : min;
                int sum = lastRowMin + matrix[i][j];
                if (sum <= nextMin) {
                    nextSecondMin = nextMin;
                    nextMin = sum;
                    nextMinCol = j;
                } else if (sum < nextSecondMin) {
                    nextSecondMin = sum;
                }
            }

            min = nextMin;
            minCol = nextMinCol;
            secondMin = nextSecondMin;
        }
        return min;
    }
}
