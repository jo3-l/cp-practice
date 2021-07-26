package binarysearch;

import java.util.*;

public class ShortestPathInAGraph {
    public int solve(int[][] edges, int start, int end) {
        Map<Integer, Vertex> vertices = new HashMap<>();
        for (int[] edge : edges) {
            Vertex vertex = vertices.computeIfAbsent(edge[0], Vertex::new);
            vertex.edges.add(new Edge(edge[1], edge[2]));
        }

        Queue<VertexWithCost> pq = new PriorityQueue<>(Comparator.comparing((VertexWithCost v) -> v.cost).reversed());
        Map<Integer, Integer> best = new HashMap<>();
        best.put(start, 0);
        Vertex root = vertices.get(start);
        if (root == null) return -1;
        pq.add(new VertexWithCost(root, 0));
        while (!pq.isEmpty()) {
            VertexWithCost cur = pq.poll();
            for (Edge e : cur.v.edges) {
                int cost = e.cost + cur.cost;
                int bestCost = best.getOrDefault(e.toId, Integer.MAX_VALUE);
                if (cost < bestCost) {
                    best.put(e.toId, cost);
                    Vertex to = vertices.get(e.toId);
                    if (to != null) pq.add(new VertexWithCost(vertices.get(e.toId), cost));
                }
            }
        }
        return best.getOrDefault(end, -1);
    }

    private static class VertexWithCost {
        public Vertex v;
        public int cost;

        public VertexWithCost(Vertex v, int cost) {
            this.v = v;
            this.cost = cost;
        }
    }

    private static class Vertex {
        public int id;
        public List<Edge> edges = new ArrayList<>();

        public Vertex(int id) {
            this.id = id;
        }
    }

    private static class Edge {
        public int toId;
        public int cost;

        public Edge(int toId, int cost) {
            this.toId = toId;
            this.cost = cost;
        }
    }
}
