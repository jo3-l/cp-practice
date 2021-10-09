package binarysearch;

public class GameOfLife {
    public int[][] solve(int[][] matrix) {
        if (matrix.length == 0) return matrix;
        int[][] next = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            int[] row = matrix[i];
            for (int j = 0; j < row.length; j++) {
                next[i][j] = nextState(matrix, i, j);
            }
        }

        return next;
    }

    private int nextState(int[][] matrix, int i, int j) {
        int neighbours = curState(matrix, i + 1, j)
                + curState(matrix, i + 1, j + 1)
                + curState(matrix, i + 1, j - 1)
                + curState(matrix, i, j + 1)
                + curState(matrix, i, j - 1)
                + curState(matrix, i - 1, j)
                + curState(matrix, i - 1, j + 1)
                + curState(matrix, i - 1, j - 1);
        if (neighbours == 2) return matrix[i][j];
        if (neighbours == 3) return 1;
        return 0;
    }

    private int curState(int[][] matrix, int i, int j) {
        if (i < 0 || i >= matrix.length) return 0;
        int[] row = matrix[i];
        if (j < 0 || j >= row.length) return 0;
        return row[j];
    }
}
