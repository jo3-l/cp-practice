package cses;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class SumOfThreeValues {
    public static void main(String[] args) {
        FastScanner sc = new FastScanner(System.in);
        int n = sc.nextInt();
        int target = sc.nextInt();
        IndexedValue[] xs = new IndexedValue[n];
        for (int i = 0; i < n; i++) {
            xs[i] = new IndexedValue(sc.nextInt(), i + 1);
        }

        Arrays.sort(xs, Comparator.comparing(v -> v.v));
        for (int i = 0; i < n; i++) {
            int cur = xs[i].v;
            int lo = 0;
            int hi = xs.length - 1;
            while (lo < hi && lo != i && hi != i) {
                int t = cur + xs[lo].v + xs[hi].v;
                if (t > target) {
                    hi--;
                } else if (t == target) {
                    System.out.println(xs[i].pos + " " + xs[lo].pos + " " + xs[hi].pos);
                    return;
                } else {
                    lo++;
                }
            }
        }
        System.out.println("IMPOSSIBLE");
    }

    private static class IndexedValue {
        public int v;
        public int pos;

        public IndexedValue(int v, int pos) {
            this.v = v;
            this.pos = pos;
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