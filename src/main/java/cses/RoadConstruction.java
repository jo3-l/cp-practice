package cses;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class RoadConstruction {
    public static void main(String[] args) throws java.io.IOException {
        FastScanner sc = new FastScanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        DSU dsu = new DSU(n + 1);
        for (int i = 1; i <= n; i++) dsu.make(i);
        BufferedWriter pw = new BufferedWriter(new java.io.OutputStreamWriter(System.out));
        while (m-- > 0) {
            dsu.union(sc.nextInt(), sc.nextInt());
            pw.write(dsu.count + " " + dsu.maxSize + "\n");
        }
        pw.flush();
    }

    private static class DSU {
        private int[] parent;
        private int[] size;
        public int maxSize;
        public int count;

        public DSU(int n) {
            parent = new int[n];
            size = new int[n];
        }

        public void make(int n) {
            parent[n] = n;
            size[n] = 1;
            maxSize = Math.max(maxSize, size[n]);
            count++;
        }

        private int find(int n) {
            if (n == parent[n]) return n;
            return parent[n] = find(parent[n]);
        }

        public void union(int a, int b) {
            a = find(a);
            b = find(b);
            if (a == b) return;
            count--;
            if (size[a] < size[b]) {
                int t = a;
                a = b;
                b = t;
            }

            parent[b] = a;
            size[a] += size[b];
            maxSize = Math.max(maxSize, size[a]);
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