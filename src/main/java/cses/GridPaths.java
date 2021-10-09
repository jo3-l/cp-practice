package cses;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class GridPaths {
    public static void main(String[] args) {
        final long MOD = (long) 1e9 + 7;
        FastScanner sc = new FastScanner(System.in);
        int n = sc.nextInt();
        long[][] dp = new long[n][n];
        for (int i = 0; i < n; i++) {
            String s = sc.nextLine();
            for (int j = 0; j < n; j++) {
                if (s.charAt(j) == '*') continue;
                if (i == 0 && j == 0) {
                    dp[i][j] = 1;
                } else {
                    if (i > 0) {
                        dp[i][j] += dp[i - 1][j];
                        dp[i][j] %= MOD;
                    }
                    if (j > 0) {
                        dp[i][j] += dp[i][j - 1];
                        dp[i][j] %= MOD;
                    }
                }
            }
        }
        System.out.println(dp[n - 1][n - 1] % MOD);
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