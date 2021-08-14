package binarysearch;

public class NumberOfIslands {
    public int solve(int[][] matrix) {
        int n = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 1) {
                    matrix[i][j] = 0;
                    flood(matrix, i, j);
                    n++;
                }
            }
        }
        return n;
    }

    private void flood(int[][] matrix, int i, int j) {
        final int[] di = {1, -1, 0, 0};
        final int[] dj = {0, 0, 1, -1};
        for (int d = 0; d < 4; d++) {
            int ii = i + di[d];
            int jj = j + dj[d];
            if (ii >= 0 && ii < matrix.length && jj >= 0 && jj < matrix[0].length && matrix[ii][jj] == 1) {
                matrix[ii][jj] = 0;
                flood(matrix, ii, jj);
            }
        }
    }
}
