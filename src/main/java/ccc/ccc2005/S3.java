package ccc.ccc2005;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import java.util.StringTokenizer;

public class S3 {
    public static void main(String[] args) {
        FastScanner sc = new FastScanner(System.in);
        int N = sc.nextInt();
        int[][] res = null;
        for (int zz = 0; zz < N; zz++) {
            int r = sc.nextInt();
            int c = sc.nextInt();
            int[][] cur = new int[r][c];
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) cur[i][j] = sc.nextInt();
            }
            if (zz == 0) {
                res = cur;
                continue;
            }

            int[][] tp = new int[res.length * r][res[0].length * c];
            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j < res[i].length; j++) {
                    int elem = res[i][j];
                    for (int m = 0; m < cur.length; m++) {
                        for (int n = 0; n < cur[m].length; n++) {
                            tp[(i * r) + m][(j * c) + n] = elem * cur[m][n];
                        }
                    }
                }
            }
            res = tp;
        }

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int maxRowSum = Integer.MIN_VALUE;
        int minRowSum = Integer.MAX_VALUE;

        assert res != null;
        int[] colSums = new int[res[0].length];
        for (int i = 0; i < res.length; i++) {
            int rowSum = 0;
            for (int j = 0; j < res[i].length; j++) {
                int elem = res[i][j];
                max = Math.max(max, elem);
                min = Math.min(min, elem);
                rowSum += elem;
                colSums[j] += elem;
            }
            maxRowSum = Math.max(maxRowSum, rowSum);
            minRowSum = Math.min(minRowSum, rowSum);
        }

        int maxColSum = Integer.MIN_VALUE;
        int minColSum = Integer.MAX_VALUE;
        for (int j = 0; j < res[0].length; j++) {
            maxColSum = Math.max(maxColSum, colSums[j]);
            minColSum = Math.min(minColSum, colSums[j]);
        }

        System.out.println(max);
        System.out.println(min);
        System.out.println(maxRowSum);
        System.out.println(minRowSum);
        System.out.println(maxColSum);
        System.out.println(minColSum);
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