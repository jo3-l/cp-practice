package binarysearch;

import java.util.Arrays;

public class ColumnSort {
    public int[][] solve(int[][] matrix) {
        if (matrix.length == 0) return matrix;
        for (int j = 0; j < matrix[0].length; j++) {
            int[] column = new int[matrix.length];
            for (int i = 0; i < matrix.length; i++) column[i] = matrix[i][j];
            Arrays.sort(column);
            for (int i = 0; i < matrix.length; i++) matrix[i][j] = column[i];
        }
        return matrix;
    }
}
