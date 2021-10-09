package binarysearch;

import java.util.ArrayDeque;
import java.util.Queue;

public class EnclosedIslands {
    public int solve(int[][] matrix) {
        Queue<Point> q = new ArrayDeque<>();
        for (int i = 0; i < matrix.length; i++) {
            int[] row = matrix[i];
            for (int j = 0; j < row.length; j++) {
                if (
                        row[j] == 1
                            && (!isValid(matrix, i - 1, j)
                            || !isValid(matrix, i + 1, j)
                            || !isValid(matrix, i, j - 1)
                            || !isValid(matrix, i, j + 1))) {
                    q.add(new Point(i, j));
                    row[j] = 0;
                }
            }
        }

        while (!q.isEmpty()) {
            Point p = q.poll();
            if (isValid(matrix, p.i - 1, p.j) && matrix[p.i - 1][p.j] == 1) {
                matrix[p.i - 1][p.j] = 0;
                q.add(new Point(p.i - 1, p.j));
            }
            if (isValid(matrix, p.i + 1, p.j) && matrix[p.i + 1][p.j] == 1) {
                matrix[p.i + 1][p.j] = 0;
                q.add(new Point(p.i + 1, p.j));
            }
            if (isValid(matrix, p.i, p.j - 1) && matrix[p.i][p.j - 1] == 1) {
                matrix[p.i][p.j - 1] = 0;
                q.add(new Point(p.i, p.j - 1));
            }
            if (isValid(matrix, p.i, p.j + 1) && matrix[p.i][p.j + 1] == 1) {
                matrix[p.i][p.j + 1] = 0;
                q.add(new Point(p.i, p.j + 1));
            }
        }

        int n = 0;
        for (int[] row : matrix) {
            for (int i : row) {
                if (i == 1) n++;
            }
        }

        return n;
    }

    private boolean isValid(int[][] matrix, int i, int j) {
        return i >= 0 && i < matrix.length && j >= 0 && j < matrix[0].length;
    }

    private static class Point {
        public int i;
        public int j;

        public Point(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
}
