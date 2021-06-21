package binarysearch;

public class RotateBy90Degrees {
    public int[][] solve(int[][] matrix) {
        int[][] cop = new int[matrix.length][matrix[0].length];

        int col = 0;
        for (int[] row : matrix) {
            for (int j = 0; j < row.length; j++) {
                cop[row.length - j - 1][col] = row[j];
            }
            col++;
        }

        return cop;
    }
}
