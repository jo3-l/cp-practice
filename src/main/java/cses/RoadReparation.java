package cses;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class RoadReparation {
    public static void main(String[] args) {
        FastScanner sc = new FastScanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        List<Edge> edges = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            edges.add(new Edge(sc.nextInt(), sc.nextInt(), sc.nextInt()));
        }

        edges.sort(Comparator.comparing(e -> e.cost));
        DSU dsu = new DSU(n + 1);
        for (int i = 1; i <= n; i++) dsu.make(i);
        int used = 0;
        long total = 0;
        for (Edge e : edges) {
            if (dsu.find(e.to) != dsu.find(e.from)) {
                dsu.union(e.to, e.from);
                used++;
                total += e.cost;
            }
        }
        if (used != n - 1) {
            System.out.println("IMPOSSIBLE");
        } else {
            System.out.println(total);
        }
    }

    private static class DSU {
        private int[] parent;
        private int[] size;

        public DSU(int n) {
            parent = new int[n];
            size = new int[n];
        }

        public void make(int n) {
            parent[n] = n;
            size[n] = 1;
        }

        private int find(int n) {
            if (n == parent[n]) return n;
            return parent[n] = find(parent[n]);
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

    private static class Edge {
        public int to;
        public int from;
        public int cost;

        public Edge(int to, int from, int cost) {
            this.to = to;
            this.from = from;
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