package binarysearch;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class ShortestAbsoluteValueDistance {
    public int solve(int[][] matrix) {
        int R = matrix.length;
        int C = matrix[0].length;
        int[][] min = new int[R][C];
        for (int i = 0; i < R; i++) Arrays.fill(min[i], Integer.MAX_VALUE);
        min[0][0] = 0;
        Queue<QE> pq = new PriorityQueue<>(Comparator.comparing(e -> e.cost));
        pq.add(new QE(0, 0, 0));
        final int[] di = {1, -1, 0, 0};
        final int[] dj = {0, 0, 1, -1};
        while (!pq.isEmpty()) {
            QE elem = pq.poll();
            if (min[elem.i][elem.j] != elem.cost) continue;
            for (int d = 0; d < 4; d++) {
                int i = elem.i + di[d];
                int j = elem.j + dj[d];
                if (i >= 0 && i < R && j >= 0 && j < C) {
                    int c = elem.cost + Math.abs(matrix[elem.i][elem.j] - matrix[i][j]);
                    if (c < min[i][j]) {
                        min[i][j] = c;
                        pq.add(new QE(c, i, j));
                    }
                }
            }
        }
        return min[R-1][C-1];
    }

    private static class QE {
        public int cost;
        public int i;
        public int j;

        public QE(int cost, int i, int j) {
            this.cost = cost;
            this.i = i;
            this.j = j;
        }
    }
}
