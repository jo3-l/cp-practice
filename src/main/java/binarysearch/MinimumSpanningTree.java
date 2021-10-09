package binarysearch;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class MinimumSpanningTree {
    public boolean solve(int[][] edges, int a, int b) {
        if (a == b) return false;
        Arrays.sort(edges, Comparator.comparing(e -> e[2]));
        int min = getBestMst(edges);

        DSU dsu = new DSU();
        int size = 0;
        for (int[] edge : edges) {
            if ((edge[0] == a && edge[1] == b) || (edge[0] == b && edge[1] == a)) {
                dsu.upsert(a);
                dsu.upsert(b);
                dsu.union(a, b);
                size += edge[2];
            }
        }

        for (int[] edge : edges) {
            dsu.upsert(edge[0]);
            dsu.upsert(edge[1]);
            if (dsu.find(edge[0]) != dsu.find(edge[1])) {
                dsu.union(edge[1], edge[0]);
                size += edge[2];
            }
        }

        return size == min;
    }

    private int getBestMst(int[][] edges) {
        int size = 0;
        DSU dsu = new DSU();
        for (int[] edge : edges) {
            dsu.upsert(edge[0]);
            dsu.upsert(edge[1]);
            if (dsu.find(edge[0]) != dsu.find(edge[1])) {
                dsu.union(edge[0], edge[1]);
                size += edge[2];
            }
        }

        return size;
    }

    private static class DSU {
        public Map<Integer, Integer> parent = new HashMap<>();
        public Map<Integer, Integer> size = new HashMap<>();

        public void upsert(int n) {
            if (parent.containsKey(n)) return;
            parent.put(n, n);
            size.put(n, 1);
        }

        public int find(int n) {
            if (parent.get(n) == n) return n;
            parent.put(n, find(parent.get(n)));
            return parent.get(n);
        }

        public void union(int a, int b) {
            a = find(a);
            b = find(b);
            if (a == b) return;
            if (size.get(a) < size.get(b)) {
                int t = a;
                a = b;
                b = t;
            }
            parent.put(b, a);
            size.merge(a, size.get(b), Integer::sum);
        }
    }
}
