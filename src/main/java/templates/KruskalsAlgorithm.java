package templates;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

// kruskal's algorithm.
// first sorts all the edges by weight.
// begins with all vertices isolated, where each vertex is in a tree.
// then, these groups are gradually connected. in each iteration,
// all edges are considered. if the ends of the current edge are in different
// trees, then this edge is chosen.
public class KruskalsAlgorithm {
    public static MinimumSpanningTree kruskal(int N, List<Edge> edges) {
        edges.sort(Comparator.comparing(e -> e.cost));
        DSU dsu = new DSU(N);
        MinimumSpanningTree mst = new MinimumSpanningTree(new ArrayList<>(), 0);
        for (Edge e : edges) {
            if (dsu.find(e.from) != dsu.find(e.to)) {
                mst.cost += e.cost;
                mst.edges.add(e);
                dsu.union(e.from, e.to);
            }
        }
        return mst;
    }

    private static class MinimumSpanningTree {
        public List<Edge> edges;
        public int cost;

        public MinimumSpanningTree(List<Edge> edges, int cost) {
            this.edges = edges;
            this.cost = cost;
        }
    }

    private static class Edge {
        public int from;
        public int to;
        public int cost;
    }

    private static class DSU {
        private int[] parent;
        private int[] size;

        public DSU(int n) {
            parent = new int[n];
            size = new int[n];

            for (int i = 0; i < n; i++) make(i);
        }

        public void make(int i) {
            parent[i] = i;
            size[i] = 1;
        }

        public int find(int i) {
            if (parent[i] == i) return i;
            return parent[i] = find(parent[i]);
        }

        public void union(int a, int b) {
            a = find(a);
            b = find(b);
            if (a == b) return;
            if (size[a] < size[b]) {
                int t = a;
                a = b;
                b = t;
            }

            parent[b] = a;
            size[a] += size[b];
        }
    }
}
