package binarysearch;

public class PascalsTriangle {
    private final int[][] firstTwoRows = {{1}, {1, 1}};

    public int[] solve(int n) {
        if (n < 2) return firstTwoRows[n];
        int[][] triangle = new int[n + 1][];
        System.arraycopy(firstTwoRows, 0, triangle, 0, firstTwoRows.length);
        for (int i = 2; i <= n; i++) {
            triangle[i] = new int[i + 1];
            int[] prevRow = triangle[i - 1];
            for (int j = 0; j <= i; j++) {
                triangle[i][j] = (j > 0 ? prevRow[j - 1] : 0) + (j < prevRow.length ? prevRow[j] : 0);
            }
        }
        return triangle[n];
    }
}
