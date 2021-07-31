package binarysearch;

public class IslandShapePerimeter {
    public int solve(int[][] matrix) {
        int p = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 1) {
                    if (isEdge(matrix, i + 1, j)) p++;
                    if (isEdge(matrix, i - 1, j)) p++;
                    if (isEdge(matrix, i, j + 1)) p++;
                    if (isEdge(matrix, i, j - 1)) p++;
                }
            }
        }
        return p;
    }

    private boolean isEdge(int[][] matrix, int i, int j) {
        if (i < 0 || i >= matrix.length) return true;
        if (j < 0 || j >= matrix[0].length) return true;
        return matrix[i][j] == 0;
    }
}
