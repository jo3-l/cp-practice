package ccc.ccc2007;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class S3 {
    public static void main(String[] args) {
        FastScanner sc = new FastScanner(System.in);
        int n = sc.nextInt();
        Map<Integer, Integer> friends = new HashMap<>(n);
        for (int i = 0; i < n; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            friends.put(from, to);
        }

        Set<Integer> seen = new HashSet<>();
        outer: for (int x = sc.nextInt(), y = sc.nextInt(); x != 0; x = sc.nextInt(), y = sc.nextInt()) {
            seen.clear();
            int cur = x;
            int dist = 0;
            while (cur != y) {
                Integer f = friends.get(cur);
                if (f == null || !seen.add(f)) {
                    System.out.println("No");
                    continue outer;
                }
                cur = f;
                if (f == y) break;
                dist++;
            }

            seen.clear();
            while (cur != x) {
                Integer f = friends.get(cur);
                if (f == null || !seen.add(f)) {
                    System.out.println("No");
                    continue outer;
                }
                if (f == x) {
                    System.out.println("Yes " + dist);
                    continue outer;
                }
                cur = f;
            }
            System.out.println("No");
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