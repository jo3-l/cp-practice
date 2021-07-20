package ccc.ccc2004;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class S2 {
    public static void main(String[] args) {
        FastScanner sc = new FastScanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] scores = new int[n];
        int[] worstRanks = new int[n];
        Arrays.fill(worstRanks, Integer.MIN_VALUE);
        while (k-- > 0) {
            IdAndScore[] rs = new IdAndScore[n];
            for (int p = 0; p < n; p++) {
                int score = sc.nextInt();
                rs[p] = new IdAndScore(p + 1, (scores[p] += score));
            }
            Arrays.sort(rs, Comparator.comparing((IdAndScore x) -> x.score).reversed());
            int rank = 1;
            int idx = 0;
            while (idx < rs.length) {
                IdAndScore vv = rs[idx];
                while (idx < rs.length && rs[idx].score == vv.score) {
                    int id = rs[idx++].id;
                    worstRanks[id - 1] = Math.max(worstRanks[id - 1], rank);
                }
                rank++;
            }
        }

        List<Integer> bestIds = new ArrayList<>();
        int bestScore = Integer.MIN_VALUE;
        for (int id = 1; id <= n; id++) {
            int cscore = scores[id - 1];
            if (cscore > bestScore) {
                bestIds.clear();
                bestIds.add(id);
                bestScore = cscore;
            } else if (cscore == bestScore) {
                bestIds.add(id);
            }
        }

        for (int id : bestIds) {
            System.out.println("Yodeller " + id + " is the TopYodeller: score " + scores[id - 1] + ", worst rank " + worstRanks[id - 1]);
        }
    }

    private static class IdAndScore {
        public int id;
        public int score;

        public IdAndScore(int id, int score) {
            this.id = id;
            this.score = score;
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