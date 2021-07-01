package binarysearch;

public class BigNumbers {
    public int solve(int[][] matrix) {
        int[] rowMax = new int[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            rowMax[i] = Integer.MIN_VALUE;
            int[] row = matrix[i];
            for (int val : row) rowMax[i] = Math.max(rowMax[i], val);
        }

        int[] colMax = new int[matrix[0].length];
        for (int j = 0; j < matrix[0].length; j++) {
            colMax[j] = Integer.MIN_VALUE;
            for (int[] row : matrix) colMax[j] = Math.max(colMax[j], row[j]);
        }

        int n = 0;
        for (int i = 0; i < matrix.length; i++) {
            int[] row = matrix[i];
            for (int j = 0; j < row.length; j++) {
                int val = matrix[i][j];
                if (val == rowMax[i] && val == colMax[j]) n++;
            }
        }
        return n;
    }
}
