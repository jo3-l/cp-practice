package binarysearch;

import java.util.HashMap;
import java.util.Map;

public class ColorMap {
    public int solve(int[][] matrix) {
        Map<Integer, Integer> cg = new HashMap<>(); // color -> group count
        final int INF = (int) 1e9 + 5;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                int oc = matrix[i][j];
                if (oc != INF) {
                    cg.merge(oc, 1, Integer::sum);
                    matrix[i][j] = INF;
                    fill(matrix, i, j, oc, INF);
                }
            }
        }
        int total = 0;
        int max = 0;
        for (Map.Entry<Integer, Integer> e : cg.entrySet()) {
            total += e.getValue();
            max = Math.max(max, e.getValue());
        }
        return total - max;
    }

    private void fill(int[][] matrix, int i, int j, int target, int clr) {
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        for (int d= 0; d<4; d++) {
            int di = i + dx[d];
            int dj = j + dy[d];
            if (di >= 0 && di < matrix.length && dj >= 0 && dj < matrix[0].length) {
                if (matrix[di][dj] == target) {
                    matrix[di][dj] = clr;
                    fill(matrix, di, dj, target, clr);
                }
            }
        }
    }
}
