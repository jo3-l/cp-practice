package templates;

import java.util.*;

public class DijkstrasAlgorithm {
    // dijikstra's algorithm; computes the shortest paths from a vertex to all other vertices in the graph.
    public static Map<Vertex, List<Vertex>> lowestCostPathsStartingAtVertex(Vertex root) {
        Map<Vertex, Integer> lowestCosts = new HashMap<>();
        // lowest cost path to root is always 0
        lowestCosts.put(root, 0);

        Queue<VertexWithCost> queue = new PriorityQueue<>(Comparator.comparing(v -> v.cost));
        // add root
        queue.add(new VertexWithCost(root, 0));

        Map<Vertex, Vertex> predecessors = new HashMap<>();
        while (!queue.isEmpty()) {
            VertexWithCost cur = queue.poll();
            for (Edge edge : cur.vertex.edges) {
                // current best cost found so far
                int currentLowestCost = lowestCosts.getOrDefault(edge.to, Integer.MAX_VALUE);
                // compute cost to get there from the current path
                int cost = lowestCosts.get(cur.vertex) + edge.cost;
                // is there an improvement in cost?
                if (cost < currentLowestCost) {
                    // update data
                    predecessors.put(edge.to, cur.vertex);
                    lowestCosts.put(edge.to, cost);
                    queue.add(new VertexWithCost(edge.to, cost));
                }
            }
        }

        Map<Vertex, List<Vertex>> paths = new HashMap<>();
        for (Vertex vertex : lowestCosts.keySet()) {
            List<Vertex> path = new ArrayList<>();
            // shortest path to vertex is
            //  (root, ..., predecessors[predecessors[predecessors[vertex]]], predecessors[predecessors[vertex]], predecessors[vertex], vertex)
            //
            // to construct this, we can start at vertex and index into predecessors until we get to root.
            // then, reverse the resulting list so it's in the proper order
            Vertex cur = vertex;
            while (cur != null && cur != root) {
                path.add(cur);
                cur = predecessors.get(cur);
            }
            path.add(root);

            // reverse
            for (int i = 0; i < path.size() >> 1; i++) {
                Vertex tmp = path.get(i);
                path.set(i, path.get(path.size() - i - 1));
                path.set(path.size() - i - 1, tmp);
            }
            paths.put(vertex, path);
        }

        return paths;
    }

    public static class Vertex {
        public int id;
        public List<Edge> edges = new ArrayList<>();

        public Vertex(int id) {
            this.id = id;
        }

        @Override
        public int hashCode() {
            return Objects.hash(id);
        }

        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof Vertex)) return false;
            Vertex v = (Vertex) obj;
            return v.id == id;
        }
    }

    public static class VertexWithCost {
        public Vertex vertex;
        public int cost;

        public VertexWithCost(Vertex vertex, int cost) {
            this.vertex = vertex;
            this.cost = cost;
        }
    }

    public static class Edge {
        public int cost;
        public Vertex to;

        public Edge(int cost, Vertex to) {
            this.cost = cost;
            this.to = to;
        }
    }
}
