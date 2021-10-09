package binarysearch;

public class TransposeMatrix {
    public int[][] solve(int[][] matrix) {
        boolean[][] done = new boolean[matrix.length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (done[i][j] || done[j][i]) continue;
                done[i][j] = done[j][i] = true;
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }

        return matrix;
    }
}
