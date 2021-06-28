package binarysearch;

import java.util.ArrayDeque;
import java.util.Objects;
import java.util.Queue;

public class PaintBucket {
    private Queue<Point> todo = new ArrayDeque<>();

    public String[][] solve(String[][] matrix, int r, int c, String target) {
        todo.add(new Point(r, c, matrix[r][c].charAt(0)));
        matrix[r][c] = "p";
        while (!todo.isEmpty()) {
            Point p = todo.poll();
            paint(matrix, p.x + 1, p.y, p.original);
            paint(matrix, p.x - 1, p.y, p.original);
            paint(matrix, p.x, p.y + 1, p.original);
            paint(matrix, p.x, p.y - 1, p.original);
        }

        // fix everything
        for (String[] xs : matrix) {
            for (int j = 0; j < xs.length; j++) {
                if (xs[j].charAt(0) == 'p') xs[j] = target;
            }
        }
        return matrix;
    }

    private void paint(String[][] matrix, int r, int c, int want) {
        if (r < 0 || r >= matrix.length) return;
        if (c < 0 || c >= matrix[0].length) return;
        char cc = matrix[r][c].charAt(0);
        if (cc == 'p' || cc != want) return;
        matrix[r][c] = "p";
        todo.add(new Point(r, c, cc));
    }

    private static class Point {
        public final int x;
        public final int y;
        public final int original;

        public Point(int x, int y, int original) {
            this.x = x;
            this.y = y;
            this.original = original;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }

        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof Point)) return false;
            Point p = (Point) obj;
            return p.x == x && p.y == y;
        }
    }
}
