package binarysearch;

public class DirectClosure {
    public int[][] solve(int[][] graph) {
        int N = graph.length;
        DSU dsu = new DSU(N);
        for (int i = 0; i < graph.length; i++) {
            for (int j : graph[i]) {
                dsu.union(i, j);
                dsu.union(j, i);
            }
        }

        int[][] mt = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                mt[i][j] = dsu.find(i) == dsu.find(j) ? 1 : 0;
            }
        }
        return mt;
    }

    private static class DSU {
        private int[] parent;
        private int[] size;

        public DSU(int N) {
            parent = new int[N];
            size = new int[N];
            for (int i = 0; i < N; i++) make(i);
        }

        public void make(int n) {
            parent[n] = n;
            size[n] = 1;
        }

        public int find(int n) {
            if (parent[n] == n) return parent[n];
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
