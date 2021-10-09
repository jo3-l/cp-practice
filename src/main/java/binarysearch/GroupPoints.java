package binarysearch;

import java.util.HashSet;
import java.util.Set;

public class GroupPoints {
    public int solve(int[][] points, int k) {
        k *= k;
        int N = points.length;
        DSU dsu = new DSU(N);
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (dist(points[i], points[j]) <= k) {
                    dsu.union(i, j);
                    dsu.union(j, i);
                }
            }
        }

        Set<Integer> ps = new HashSet<>();
        for (int i = 0; i < N; i++) {
            ps.add(dsu.find(i));
        }
        return ps.size();
    }

    private int dist(int[] p0, int[] p1) {
        int x = p0[0] - p1[0];
        int y = p0[1] - p1[1];
        return x * x + y * y;
    }

    private static class DSU {
        private int[] parent;
        private int[] size;

        public DSU(int N) {
            parent = new int[N];
            size = new int[N];
            for (int i =0; i < N; i++) make(i);
        }

        public void make(int n) {
            parent[n] = n;
            size[n] = 1;
        }

        public int find(int n) {
            if (parent[n] == n) return n;
            return parent[n] = find(parent[n]);
        }

        public void union(int a, int b) {
            a = find(a);
            b = find(b);
            if (a == b) return;
            if (size[a] < size[b]) {
                int tmp = a;
                a = b;
                b = tmp;
            }
            parent[b] = a;
            size[b] += size[a];
        }
    }
}
