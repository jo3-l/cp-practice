package cses;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class MinimizingCoins {
    public static void main(String[] args) {
        final int INF = (int) 1e9 + 5;
        FastScanner sc = new FastScanner(System.in);
        int n = sc.nextInt();
        int x = sc.nextInt();
        int[] coins = new int[n];
        int[] dp = new int[x + 1]; // dp[k] = number of ways to create k
        Arrays.fill(dp, INF);
        for (int i = 0; i < n; i++) {
            coins[i] = sc.nextInt();
        }
        dp[0] = 0;
        for (int j = 0; j <= x; j++) {
            for (int coin : coins) {
                if (j < coin) continue;
                int ways = 0;
                if (dp[j - coin] != INF) ways = dp[j - coin] + 1;
                if (ways < dp[j] && ways != 0) dp[j] = ways;
            }
        }
        System.out.println(dp[x] == INF ? -1 : dp[x]);
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