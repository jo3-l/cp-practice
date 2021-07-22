package ccc.ccc2007;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S5 {
    public static void main(String[] args) {
        FastScanner sc = new FastScanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int w = sc.nextInt();
            int[] pfs = new int[n];
            pfs[0] = sc.nextInt();
            for (int i = 1; i < n; i++) pfs[i] = pfs[i - 1] + sc.nextInt();
            int[][] dp = new int[n][k]; // dp[i][j] corresponds to the max score we can get in pins[0..i], inclusive, with j pins left
            dp[0][k - 1] = pfs[0];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < k; j++) {
                    int canKnock = Math.min(i + 1, w);
                    int total = pfs[i];
                    if (i >= canKnock) total -= pfs[i - canKnock];
                    dp[i][j] = (i < canKnock || j == k - 1 ? 0 : dp[i - canKnock][j + 1]) + total;
                    if (i > 0) dp[i][j] = Math.max(dp[i][j], dp[i - 1][j]);
                }
            }
            int max = 0;
            for (int i = 0; i < k; i++) {
                max = Math.max(max, dp[n - 1][i]);
            }
            System.out.println(max);
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