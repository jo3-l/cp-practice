package binarysearch;

import java.util.ArrayDeque;
import java.util.Deque;

public class WildfireSequel {
    public boolean solve(int[][] matrix) {
        int R = matrix.length;
        int C = matrix[0].length;
        Deque<int[]> q = new ArrayDeque<>();
        int ct = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (matrix[i][j] == 2 || matrix[i][j] == 1) {
                    if ((i == 0 && j == 0) || (i == R - 1 && j == C - 1)) {
                        if (matrix[i][j] == 2) ct++;
                        else return true;
                    }
                    int[] elem = {i, j, matrix[i][j]};
                    if (matrix[i][j] == 1) q.addFirst(elem);
                    else q.addLast(elem);
                    matrix[i][j] = 2;
                }
            }
        }
        if (ct == 2) return false;
        final int[] di = {1, -1, 0, 0};
        final int[] dj = {0, 0, 1, -1};
        while (!q.isEmpty()) {
            int sz = q.size();
            boolean pm = false;
            while (sz-- > 0) {
                int[] coord = q.poll();
                int i = coord[0];
                int j = coord[1];
                int typ = coord[2];
                for (int d = 0; d < 4; d++) {
                    int ii = i + di[d];
                    int jj = j + dj[d];
                    if (ii >= 0 && ii < R && jj >= 0 && jj < C) {
                        if (matrix[ii][jj] == 3 || matrix[ii][jj] == 2) continue;
                        if (typ == 1 && ((ii == 0 && jj == 0) || (ii == R - 1 && jj == C - 1))) {
                            return true;
                        }
                        q.addLast(new int[]{ii, jj, typ});
                        matrix[ii][jj] = 2;
                        pm = pm || typ == 1;
                    }
                }
            }
            if (!pm) break;
        }
        return false;
    }
}
