package binarysearch;

import java.util.*;

public class NearestBusStopFromHome {
    private Queue<Point> queue = new LinkedList<>();
    private Set<Point> visited = new HashSet<>();
    private int[][] matrix;

    public int solve(int[][] matrix) {
        this.matrix = matrix;

        // start with all the houses
        for (int i = 0; i < matrix.length; i++) {
            int[] v = matrix[i];
            for (int j = 0; j < v.length; j++) {
                int x = v[j];
                if (x == 2) {
                    Point p = new Point(i, j);
                    queue.add(p);
                    visited.add(p);
                }
            }
        }

        int dist = 1;
        while (!queue.isEmpty()) {
            int b = queue.size();
            while (b-- > 0) {
                Point p = queue.poll();
                if (
                        tryMove(p.x + 1, p.y)
                                || tryMove(p.x - 1, p.y)
                                || tryMove(p.x, p.y + 1)
                                || tryMove(p.x, p.y - 1)
                ) {
                    return dist;
                }
            }

            dist++;
        }

        return -1;
    }

    private boolean tryMove(int x, int y) {
        if (x < 0 || x >= matrix.length) return false;
        int[] r = matrix[x];
        if (y < 0 || y >= r.length) return false;
        switch (r[y]) {
            case 0: // empty cell, OK
                break;
            case 1: // wall
            case 2: // house
                return false; // can't go there
            case 3:
                return true; // bus stop!
        }
        Point p = new Point(x, y);
        if (visited.contains(p)) return false;
        queue.add(p);
        visited.add(p);
        return false;
    }

    private static class Point {
        public final int x;
        public final int y;

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
            Point objCast = (Point) obj;
            return x == objCast.x && y == objCast.y;
        }
    }
}
