package binarysearch;

import java.util.BitSet;

public class ConnectCartesianCoordinates {
    public int solve(int[][] points) {
        if (points.length == 0) return 0;
        int N = points.length;

        int totalCost = 0;
        BitSet selected = new BitSet(N + 1);
        Edge[] minEdges = new Edge[points.length];
        minEdges[0] = new Edge(-1, 0);

        for (int i = 0; i < N; i++) {
            int v = -1;
            for (int j = 0; j < N; j++) {
                if (selected.get(j)) continue;
                if (v == -1) {
                    v = j;
                } else {
                    int a = minEdges[j] == null ? Integer.MAX_VALUE : minEdges[j].cost;
                    int b = minEdges[v] == null ? Integer.MAX_VALUE : minEdges[v].cost;
                    if (a < b) v = j;
                }
            }

            Edge min = minEdges[v];
            if (min == null) return -1; // no MST

            selected.set(v);
            totalCost += min.cost;

            for (int to = 0; to < N; to++) {
                int curCost = cost(points[v], points[to]);
                int best = minEdges[to] == null ? Integer.MAX_VALUE : minEdges[to].cost;
                if (curCost < best) {
                    minEdges[to] = new Edge(v, curCost);
                }
            }
        }
        return totalCost;
    }

    private int cost(int[] first, int[] second) {
        return Math.abs(first[0] - second[0]) + Math.abs(first[1] - second[1]);
    }

    private static class Edge {
        public int to;
        public int cost;

        public Edge(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }
}
