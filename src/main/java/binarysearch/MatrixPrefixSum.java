package binarysearch;

public class MatrixPrefixSum {
    public int[][] solve(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            int[] row = matrix[i];
            for (int j = 0; j < row.length; j++) {
                if (j > 0) row[j] += row[j - 1];
                if (i > 0) row[j] += matrix[i - 1][j];
                if (j > 0 && i > 0) row[j] -= matrix[i - 1][j - 1];
            }
        }
        return matrix;
    }
}
