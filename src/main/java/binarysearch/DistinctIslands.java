package binarysearch;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class DistinctIslands {
    private final int[] di = {1, -1, 0, 0};
    private final int[] dj = {0, 0, 1, -1};

    public int solve(int[][] matrix) {
        List<List<int[]>> islands = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 1) {
                    matrix[i][j] = 0;
                    List<int[]> points = new ArrayList<>();
                    points.add(new int[]{i, j});
                    go(matrix, i, j, points);
                    canonicalize(points);

                    int k;
                    for (k = 0; k < islands.size(); k++) {
                        List<int[]> island = islands.get(k);
                        if (island.size() == points.size()) {
                            int z;
                            for (z = 0; z < island.size(); z++) {
                                int[] p0 = points.get(z);
                                int[] p1 = island.get(z);
                                if (p0[0] != p1[0] || p0[1] != p1[1]) break;
                            }
                            if (z >= island.size()) break;
                        }
                    }
                    if (k >= islands.size()) islands.add(points);
                }
            }
        }
        return islands.size();
    }

    private void canonicalize(List<int[]> points) {
        points.sort(Comparator.comparing((int[] p) -> p[0]).thenComparing((int[] p) -> p[1]));
        int si = points.get(0)[0];
        int sj = points.get(0)[1];
        for (int[] p : points) {
            p[0] -= si;
            p[1] -= sj;
        }
    }

    private void go(int[][] matrix, int i, int j, List<int[]> points) {
        for (int d = 0; d < 4; d++) {
            int ni = i + di[d];
            int nj = j + dj[d];
            if (0 <= ni && ni < matrix.length && 0 <= nj && nj < matrix[0].length) {
                if (matrix[ni][nj] == 1) {
                    matrix[ni][nj] = 0;
                    points.add(new int[]{ni, nj});
                    go(matrix, ni, nj, points);
                }
            }
        }
    }
}
