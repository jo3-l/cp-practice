package ccc.ccc2003;

import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.*;

public class S5 {
    public static void main(String[] args) {
        FastScanner sc = new FastScanner(System.in);
        FastOutputWriter out = new FastOutputWriter(System.out);
        int c = sc.nextInt();
        int r = sc.nextInt();
        int d = sc.nextInt();
        Road[] roads = new Road[r];
        for (int i = 0; i < r; i++) roads[i] = new Road(sc.nextInt(), sc.nextInt(), sc.nextInt());
        Arrays.sort(roads, Comparator.comparing((Road rr) -> rr.capacity).reversed());
        BitSet dest = new BitSet(c + 1);
        for (int i = 0; i < d; i++) dest.set(sc.nextInt());
        DSU dsu = new DSU(c);
        int cap = -1;
        int comps = 0;
        for (Road rd : roads) {
            if (dsu.find(rd.from) != dsu.find(rd.to)) {
                if (dest.get(rd.from)) {
                    comps++;
                    dest.set(rd.from, false);
                }
                if (dest.get(rd.to)) {
                    comps++;
                    dest.set(rd.to, false);
                }
                dsu.union(rd.from, rd.to);
                cap = rd.capacity;
                if (comps == d) break;
            }
        }
        out.println(cap);
        out.close();
    }

    private static class DSU {
        private int[] parent;
        private int[] size;

        public DSU(int n) {
            parent = new int[n + 1];
            size = new int[n + 1];
            for (int i = 1; i <= n; i++) make(i);
        }

        public void make(int i) {
            parent[i] = i;
            size[i] = 1;
        }

        public int find(int n) {
            if (parent[n] == n) return n;
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

    private static class Road {
        public int from;
        public int to;
        public int capacity;

        public Road(int from, int to, int capacity) {
            this.from = from;
            this.to = to;
            this.capacity = capacity;
        }
    }

    public static class FastOutputWriter {
        public BufferedWriter wr;

        public FastOutputWriter(OutputStream st) {
            wr = new BufferedWriter(new OutputStreamWriter(st));
        }

        public void println(boolean b) {
            try {
                wr.write(String.valueOf(b));
                wr.write('\n');
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        public void println(char c) {
            try {
                wr.write(String.valueOf(c));
                wr.write('\n');
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        public void println(int i) {
            try {
                wr.write(String.valueOf(i));
                wr.write('\n');
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        public void println(long l) {
            try {
                wr.write(String.valueOf(l));
                wr.write('\n');
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        public void println(float f) {
            try {
                wr.write(String.valueOf(f));
                wr.write('\n');
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        public void println(double d) {
            try {
                wr.write(String.valueOf(d));
                wr.write('\n');
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        public void println(String s) {
            try {
                wr.write(String.valueOf(s));
                wr.write('\n');
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        public void println(char[] cs) {
            try {
                wr.write(cs);
                wr.write('\n');
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        public void println(Object o) {
            try {
                wr.write(String.valueOf(o));
                wr.write('\n');
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        public void println() {
            try {
                wr.write('\n');
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        public void print(boolean b) {
            try {
                wr.write(String.valueOf(b));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        public void print(char c) {
            try {
                wr.write(String.valueOf(c));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        public void print(int i) {
            try {
                wr.write(String.valueOf(i));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        public void print(long l) {
            try {
                wr.write(String.valueOf(l));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        public void print(float f) {
            try {
                wr.write(String.valueOf(f));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        public void print(double d) {
            try {
                wr.write(String.valueOf(d));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        public void print(String s) {
            try {
                wr.write(String.valueOf(s));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        public void print(char[] cs) {
            try {
                wr.write(cs);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        public void print(Object o) {
            try {
                wr.write(String.valueOf(o));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        public void flush() {
            try {
                wr.flush();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        public void close() {
            try {
                wr.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }


    public static class FastScanner {
        public StringTokenizer st;
        public BufferedReader br;

        public FastScanner(InputStream s) {
            br = new BufferedReader(new InputStreamReader(s));
            st = null;
        }

        public String nextLine() {
            try {
                return br.readLine();
            } catch (Exception e) {
                throw new RuntimeException(e);
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
                    throw new RuntimeException(e);
                }
            }
            return st.nextToken();
        }
    }
}