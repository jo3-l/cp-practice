package binarysearch;

import java.util.*;

public class EscapeMaze {
    public int solve(int[][] matrix) {
        if (matrix[0][0] == 1) return -1;
        if (matrix.length == 1 && matrix[0].length == 1) return 1;
        Queue<Point> q = new ArrayDeque<>();
        Set<Point> s = new HashSet<>();
        Point p = new Point(0, 0);
        Point want = new Point(matrix.length - 1, matrix[0].length - 1);
        q.add(p);
        s.add(p);

        int mv = 1;
        while (!q.isEmpty()) {
            int sz = q.size();
            while (sz-- > 0) {
                Point pp = q.poll();
                Point cur;
                if (isValid(matrix, pp.x + 1, pp.y) && s.add(cur = new Point(pp.x + 1, pp.y))) q.add(cur);
                if (isValid(matrix, pp.x - 1, pp.y) && s.add(cur = new Point(pp.x - 1, pp.y))) q.add(cur);
                if (isValid(matrix, pp.x, pp.y + 1) && s.add(cur = new Point(pp.x, pp.y + 1))) q.add(cur);
                if (isValid(matrix, pp.x, pp.y - 1) && s.add(cur = new Point(pp.x, pp.y - 1))) q.add(cur);
                if (s.contains(want)) return mv + 1;
            }
            mv++;
        }
        return -1;
    }

    private boolean isValid(int[][] matrix, int x, int y) {
        if (x < 0 || x >= matrix.length) return false;
        if (y < 0 || y >= matrix[0].length) return false;
        return matrix[x][y] == 0;
    }

    private static class Point {
        public int x;
        public int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
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

        @Override
        public String toString() {
            return "Point(" + x + ", " + y + ")";
        }
    }
}
