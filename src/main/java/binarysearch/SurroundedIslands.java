package binarysearch;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class SurroundedIslands {
    public int solve(int[][] matrix) {
        Queue<int[]> q = new ArrayDeque<>();
        for (int i = 0; i < matrix.length; i++) {
            int[] row = matrix[i];
            for (int j = 0; j < row.length; j++) {
                if (row[j] == 1) {
                    boolean isOnEdge = (j == 0 || j == row.length - 1)
                            || (i == 0 || i == matrix.length - 1);
                    if (isOnEdge) {
                        row[j] = 0;
                        flood(matrix, i, j);
                    }
                }
            }
        }

        int n = 0;
        for (int i = 0; i < matrix.length; i++) {
            int[] row = matrix[i];
            for (int j = 0; j < row.length; j++) {
                if (row[j] == 1) {
                    n++;
                    row[j] = 0;
                    flood(matrix, i, j);
                }
            }
        }
        return n;
    }

    private void flood(int[][] matrix, int i, int j) {
        for (int[] adj : adjacent(matrix, i, j)) {
            if (matrix[adj[0]][adj[1]] == 1) {
                matrix[adj[0]][adj[1]] = 0;
                flood(matrix, adj[0], adj[1]);
            }
        }
    }

    private List<int[]> adjacent(int[][] matrix, int i, int j) {
        List<int[]> ret = new ArrayList<>();
        if (isIn(matrix, i + 1, j)) ret.add(new int[]{i + 1, j});
        if (isIn(matrix, i - 1, j)) ret.add(new int[]{i - 1, j});
        if (isIn(matrix, i, j + 1)) ret.add(new int[]{i, j + 1});
        if (isIn(matrix, i, j - 1)) ret.add(new int[]{i, j - 1});
        return ret;
    }

    private boolean isIn(int[][] matrix, int i, int j) {
        return i >= 0 && i < matrix.length && j >= 0 && j < matrix[0].length;
    }
}
