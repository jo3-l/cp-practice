package binarysearch;

public class CollectingCoins {
    private int[][] dp;
    private int nRow;
    private int nCol;

    public int solve(int[][] matrix) {
        nRow = matrix.length;
        nCol = matrix[0].length;
        dp = new int[nRow][nCol];
        return go(matrix, 0, 0);
    }

    private int go(int[][] matrix, int x, int y) {
        if (!goodMove(x, y)) return 0;
        if (dp[x][y] != 0) return dp[x][y];
        int cur = matrix[x][y];
        return dp[x][y] = cur + Math.max(
                go(matrix, x + 1, y), // move right
                go(matrix, x, y + 1) // move left
        );
    }

    private boolean goodMove(int x, int y) {
        return (x >= 0 && x < nRow) && (y >= 0 && y < nCol);
    }
}
