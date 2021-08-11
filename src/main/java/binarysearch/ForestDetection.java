package binarysearch;

import java.util.HashMap;
import java.util.Map;

public class ForestDetection {
    public boolean solve(int[][] edges) {
        DSU dsu = new DSU();
        for (int[] edge : edges) {
            dsu.upsert(edge[0]);
            dsu.upsert(edge[1]);
            if (dsu.find(edge[0]) == dsu.find(edge[1])) return false;
            dsu.union(edge[0], edge[1]);
        }
        return true;
    }

    private static class DSU {
        private Map<Integer, Integer> parent = new HashMap<>();
        private Map<Integer, Integer> size = new HashMap<>();

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
