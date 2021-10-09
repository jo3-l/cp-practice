package ccc.ccc2009;

import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.*;

public class S4 {
    public static void main(String[] args) {
        FastScanner sc = new FastScanner(System.in);
        FastOutputWriter out = new FastOutputWriter(System.out);
        int n = sc.nextInt();
        int t = sc.nextInt();
        int[][] trc = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) Arrays.fill(trc[i], Integer.MAX_VALUE);
        for (int i = 0; i < t; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int c = sc.nextInt();
            trc[x][y] = trc[y][x] = c;
        }
        int[] pc = new int[n + 1];
        Arrays.fill(pc, Integer.MAX_VALUE);
        int k = sc.nextInt();
        for (int i = 0; i < k; i++) {
            pc[sc.nextInt()] = sc.nextInt();
        }

        int d = sc.nextInt();
        // shortest distance from city d to any city i where pc[i] != INF
        int[] mins = new int[n + 1];
        Arrays.fill(mins, Integer.MAX_VALUE);
        mins[d] = 0;
        Queue<QE> pq = new PriorityQueue<>(Comparator.comparing(e -> e.cst));
        pq.add(new QE(0, d));
        while (!pq.isEmpty()) {
            QE e = pq.poll();
            if (mins[e.city] != e.cst) continue;
            for (int dst = 1; dst <= n; dst++) {
                if (dst != e.city && trc[e.city][dst] != Integer.MAX_VALUE) {
                    int c = e.cst + trc[e.city][dst];
                    if (c < mins[dst]) {
                        mins[dst] = c;
                        pq.add(new QE(c, dst));
                    }
                }
            }
        }

        int b = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            if (pc[i] != Integer.MAX_VALUE) {
                b = Math.min(b, mins[i] + pc[i]);
            }
        }
        out.println(b);
        out.close();
    }

    private static class QE {
        public int cst;
        public int city;

        public QE(int cst, int city) {
            this.cst = cst;
            this.city = city;
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