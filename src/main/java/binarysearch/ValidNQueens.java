package binarysearch;

public class ValidNQueens {
    public boolean solve(int[][] matrix) {
        int rows = 0;
        int cols = 0;
        for (int i = 0; i < matrix.length; i++) {
            int[] row = matrix[i];
            int rbit = 1 << i;
            for (int j = 0; j < row.length; j++) {
                if (row[j] == 0) continue;
                int cbit = 1 << j;
                if ((rows & rbit) != 0) return false;
                if ((cols & cbit) != 0) return false;

                // check diag moving right
                for (int r = i - 1, c = j - 1; r >= 0 && c >= 0; r--, c--) {
                    if (matrix[r][c] == 1) return false;
                }
                for (int r = i + 1, c = j + 1; r < matrix.length && c < matrix.length; r++, c++) {
                    if (matrix[r][c] == 1) return false;
                }

                // check diag moving left
                for (int r = i + 1, c = j - 1; r < matrix.length && c >= 0; r++, c--) {
                    if (matrix[r][c] == 1) return false;
                }
                for (int r = i - 1, c = j + 1; r >= 0 && c < matrix.length; r--, c++) {
                    if (matrix[r][c] == 1) return false;
                }

                rows |= rbit;
                cols |= cbit;
            }
        }

        return rows == ((1 << matrix.length) - 1);
    }
}
