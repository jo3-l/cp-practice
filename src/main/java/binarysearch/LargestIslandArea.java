package binarysearch;

public class LargestIslandArea {
    public int solve(int[][] matrix) {
        int a = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 1) {
                    matrix[i][j] = 0;
                    int[] r = {0};
                    floodfill(matrix, i, j, r);
                    a = Math.max(a, r[0]);
                }
            }
        }
        return a;
    }

    private void floodfill(int[][] matrix, int i, int j, int[] ref) {
        final int[] di = {1, -1, 0, 0};
        final int[] dj = {0, 0, 1, -1};
        ref[0]++;
        for (int z = 0; z < 4; z++) {
            int ci = i + di[z];
            int cj = j + dj[z];
            if (ci >= 0 && ci < matrix.length && cj >= 0 && cj < matrix[0].length && matrix[ci][cj] == 1) {
                matrix[ci][cj] = 0;
                floodfill(matrix, ci, cj, ref);
            }
        }
    }
}
