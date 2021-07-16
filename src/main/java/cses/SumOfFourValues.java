package cses;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class SumOfFourValues {
    public static void main(String[] args) {
        FastScanner sc = new FastScanner(System.in);
        Map<Integer, List<IndexPair>> tsums = new HashMap<>();
        int n = sc.nextInt();
        int target = sc.nextInt();
        int[] xs = new int[n];
        for (int i = 0; i < n; i++) xs[i] = sc.nextInt();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int sm = xs[i] + xs[j];
                List<IndexPair> ps = tsums.computeIfAbsent(sm, k -> new ArrayList<>());
                ps.add(new IndexPair(i, j));
            }
        }

        for (Map.Entry<Integer, List<IndexPair>> e0 : tsums.entrySet()) {
            int want = target - e0.getKey();
            List<IndexPair> other = tsums.get(want);
            if (other == null) continue;
            for (IndexPair i0 : e0.getValue()) {
                for (IndexPair i1 : other) {
                    if (!i0.overlapsWith(i1)) {
                        System.out.println((i0.idx0 + 1) + " " + (i0.idx1 + 1) + " " + (i1.idx0 + 1) + " " + (i1.idx1 + 1));
                        return;
                    }
                }
            }
        }
        System.out.println("IMPOSSIBLE");
    }

    public static class IndexPair {
        public int idx0;
        public int idx1;

        public IndexPair(int i0, int i1) {
            idx0 = i0;
            idx1 = i1;
        }

        public boolean overlapsWith(IndexPair p) {
            return p.idx0 == idx0 || p.idx0 == idx1 || p.idx1 == idx0 || p.idx1 == idx1;
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