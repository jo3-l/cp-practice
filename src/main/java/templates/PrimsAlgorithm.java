package templates;

import java.util.*;

public class PrimsAlgorithm {
    public static MinimumSpanningTree prim(Map<Integer, Vertex> graph) {
        int totalCost = 0;
        List<Integer> path = new ArrayList<>();
        Set<Integer> selected = new HashSet<>();
        Map<Integer, Edge> minEdges = new HashMap<>();

        // select an arbitrary vertex to start at
        Iterator<Integer> keyIter = graph.keySet().iterator();
        minEdges.put(keyIter.next(), new Edge(-1, 0));

        // iterate until we've found a MST or confirmed it's impossible
        int vertexCount = graph.size();
        while (vertexCount-- > 0) {
            // find node with minimum distance
            int v = -1;
            for (int j : graph.keySet()) {
                if (!selected.contains(j) &&
                        (v == -1 || minEdges.getOrDefault(j, Edge.NULL).cost < minEdges.getOrDefault(v, Edge.NULL).cost)) {
                    v = j;
                }
            }

            Edge minEdge = minEdges.get(v);
            if (minEdge == null) {
                return null; // no MST
            }

            // mark as selected and update cost
            selected.add(v);
            totalCost += minEdge.cost;
            if (minEdge.toId != -1) path.add(minEdge.toId);

            // relax distance of remaining nodes
            Vertex vv = graph.get(v);
            for (int to : graph.keySet()) {
                int curCost = vv.edges.getOrDefault(to, Edge.NULL).cost;
                if (curCost < minEdges.getOrDefault(to, Edge.NULL).cost) {
                    minEdges.put(to, new Edge(v, curCost));
                }
            }
        }

        return new MinimumSpanningTree(path, totalCost);
    }

    private static class MinimumSpanningTree {
        public List<Integer> path;
        public int cost;

        public MinimumSpanningTree(List<Integer> path, int cost) {
            this.path = path;
            this.cost = cost;
        }
    }

    private static class Vertex {
        private int id;
        private Map<Integer, Edge> edges = new HashMap<>();

        public Vertex(int id) {
            this.id = id;
        }
    }

    private static class Edge {
        public static final Edge NULL = new Edge(-1, Integer.MAX_VALUE);
        public int toId;
        public int cost;

        public Edge(int toId, int cost) {
            this.toId = toId;
            this.cost = cost;
        }
    }
}
