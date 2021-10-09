package binarysearch;

import java.util.HashSet;
import java.util.Set;

public class CommunicationTowers {
    public int solve(int[][] matrix) {
        int R = matrix.length;
        int C = matrix[0].length;
        DSU dsu = new DSU(R, C);
        for (int i = 0; i < R; i++) {
            int j = 0;
            while (j < C && matrix[i][j] != 1) j++;
            int p = j;
            for (; j < C; j++) {
                if (matrix[i][j] == 1) dsu.union(new int[]{i, p}, new int[]{i, j});
            }
        }
        for (int j = 0; j < C; j++) {
            int i = 0;
            while (i < R && matrix[i][j] != 1) i++;
            int p = i;
            for (; i < R; i++) {
                if (matrix[i][j] == 1) dsu.union(new int[]{p, j}, new int[]{i, j});
            }
        }

        Set<Integer> uniq = new HashSet<>();
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (matrix[i][j] == 1) {
                    int[] p = dsu.find(new int[]{i, j});
                    uniq.add(p[0] * 252 + p[1]);
                }
            }
        }
        return uniq.size();
    }

    private static class DSU {
        private int[][][] parent;
        private int[][] size;
        private int R;
        private int C;

        public DSU(int R, int C) {
            this.R = R;
            this.C = C;
            parent = new int[R][C][];
            size = new int[R][C];

            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) make(i, j);
            }
        }

        public void make(int i, int j) {
            parent[i][j] = new int[]{i, j};
            size[i][j] = 1;
        }

        public int[] find(int[] ij) {
            int[] p = parent[ij[0]][ij[1]];
            if (p[0] == ij[0] && p[1] == ij[1]) return p;
            return parent[ij[0]][ij[1]] = find(p);
        }

        public void union(int[] ij0, int[] ij1) {
            int[] a = find(ij0);
            int[] b = find(ij1);
            if (a[0] == b[0] && a[1] == b[1]) return;
            if (size[a[0]][a[1]] > size[b[0]][b[1]]) {
                int[] tmp = a;
                a = b;
                b = tmp;
            }
            parent[b[0]][b[1]] = a;
            size[a[0]][a[1]] += size[b[0]][b[1]];
        }
    }
}
