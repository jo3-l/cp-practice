package templates;

import java.util.*;

// Prim's algorithm.
// starts by choosing a single vertex. then, the minimum weight edge from this vertex is selected,
// and then the minimum weight edge that connects to an already selected vertex, and so on until
// all vertices are selected.
public class PrimsAlgorithm {
    // prim's algorithm for dense graphs, with O(n^2) complexity
    public static MinimumSpanningTree primOnDenseGraph(Map<Integer, Vertex> graph) {
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
            // find minimum weight edge from
            int minWeightEdge = -1;
            int minWeightEdgeCost = Integer.MAX_VALUE;
            for (int v : graph.keySet()) {
                if (selected.contains(v)) continue; // already in MST, can't choose it
                if (
                        minWeightEdge == -1 // no node selected for current iteration so far
                                || minEdges.getOrDefault(v, Edge.NULL).cost < minWeightEdgeCost // weight for this edge is better than the current one selected
                ) {
                    minWeightEdge = v;
                    minWeightEdgeCost = minEdges.getOrDefault(v, Edge.NULL).cost;
                }
            }

            // get minimum weight edge for the vertex we chose
            Edge minEdge = minEdges.get(minWeightEdge);
            if (minEdge == null) {
                return null; // no MST
            }

            // mark as selected and update cost
            selected.add(minWeightEdge);
            totalCost += minEdge.cost;
            if (minEdge.toId != -1) path.add(minEdge.toId);

            // since we added an edge, some minimum edges may have to be changed
            Vertex v = graph.get(minWeightEdge);
            for (int to : graph.keySet()) {
                // did the cost improve?
                int cost = v.edges.getOrDefault(to, Edge.NULL).cost;
                if (cost < minEdges.getOrDefault(to, Edge.NULL).cost) {
                    minEdges.put(to, new Edge(minWeightEdge, cost));
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
