// This MLEs on case 31 (100k vertices and 100k-1 edges) : (
// It works correctly, though, so oh well...
package codeforces;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Dijkstra {
    public static void main(String[] args) {
        FastScanner sc = new FastScanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        @SuppressWarnings("unchecked")
        List<Edge>[] edges = new List[n + 1];

        while (m-- > 0) {
            int v0 = sc.nextInt();
            int v1 = sc.nextInt();
            int cost = sc.nextInt();
            if (edges[v0] == null) edges[v0] = new ArrayList<>(1);
            if (edges[v1] == null) edges[v1] = new ArrayList<>(1);
            edges[v0].add(new Edge(v1, cost));
            edges[v1].add(new Edge(v0, cost));
        }

        int[] predecessors = new int[n + 1];
        int[] res = new int[n + 1];
        Arrays.fill(res, Integer.MAX_VALUE);
        res[1] = 0;
        Queue<VertexWithCost> queue = new PriorityQueue<>(Comparator.comparing(v -> v.cost));
        queue.add(new VertexWithCost(1, 0));
        while (!queue.isEmpty()) {
            VertexWithCost v = queue.poll();
            if (res[v.vertex] != v.cost) continue;
            if (edges[v.vertex] == null) continue;
            for (Edge e : edges[v.vertex]) {
               int best = res[e.to];
               int cur = res[v.vertex] + e.cost;
               if (cur < best) {
                   res[e.to] = cur;
                   predecessors[e.to] = v.vertex;
                   queue.add(new VertexWithCost(e.to, cur));
               }
            }
        }

        if (res[n] == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            List<Integer> path = new ArrayList<>();
            for (int cur = n; cur != 0 && cur != 1; cur = predecessors[cur]) {
                path.add(cur);
            }
            path.add(1);
            StringBuilder sb = new StringBuilder();
            for (int i = path.size() - 1; i >= 0; i--) {
                if (i != path.size() - 1) sb.append(' ');
                sb.append(path.get(i));
            }
            System.out.println(sb);
        }
    }

    public static class VertexWithCost {
        public int vertex;
        public int cost;

        public VertexWithCost(int vertex, int cost) {
            this.vertex = vertex;
            this.cost = cost;
        }
    }

    private static class Edge {
        public int to;
        public int cost;

        public Edge(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }

    public static class FastScanner {
        private StringTokenizer st;
        private BufferedReader br;

        public FastScanner(InputStream s) {
            br = new BufferedReader(new InputStreamReader(s));
            st = null;
        }

        public String nextLine() {
            try {
                return br.readLine();
            } catch (Exception e) {
                throw new RuntimeException();
            }
        }

        public int nextInt() {
            String s = next();
            boolean neg = s.charAt(0) == '-';
            int n = 0;
            for (int i = neg ? 1 : 0; i < s.length(); i++) {
                n *= 10;
                n += s.charAt(i) - '0';
            }
            return neg ? -n : n;
        }

        public long nextLong() {
            String s = next();
            boolean neg = s.charAt(0) == '-';
            long n = 0;
            for (int i = neg ? 1 : 0; i < s.length(); i++) {
                n *= 10;
                n += s.charAt(i) - '0';
            }
            return n;
        }

        public float nextFloat() {
            return Float.parseFloat(next());
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }

        public String next() {
            if (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (Exception e) {
                    throw new RuntimeException();
                }
            }
            return st.nextToken();
        }
    }
}