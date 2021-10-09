package binarysearch;

import java.util.HashSet;
import java.util.Set;

public class FriendGroups {
    public int solve(int[][] friends) {
        DSU dsu = new DSU(friends.length);
        for (int n = 0; n < friends.length; n++) {
            for (int f : friends[n]) {
                dsu.union(n, f);
                dsu.union(f, n);
            }
        }
        Set<Integer> xs = new HashSet<>();
        for (int i = 0; i < dsu.parent.length; i++) {
            xs.add(dsu.find(i));
        }
        return xs.size();
    }

    private static class DSU {
        private int[] parent;
        private int[] size;

        public DSU(int N) {
            this.parent = new int[N];
            this.size = new int[N];
            for (int n = 0; n < N; n++) make(n);
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
