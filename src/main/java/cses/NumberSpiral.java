package cses;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class NumberSpiral {
    public static void main(String[] args) {
        FastScanner sc = new FastScanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int r = sc.nextInt();
            int c = sc.nextInt();
            long sn = Math.max(r, c); // spiral number we're on
            // last number of this spiral
            long lv = sn * sn;
            if ((sn & 1) == 1) {
                // moving down, then left for this spiral
                lv -= r - 1;
                if (c < sn) lv -= sn - c;
            } else {
                // moving right, then up for this spiral
                lv -= c - 1;
                if (r < sn) lv -= sn - r;
            }

            System.out.println(lv);
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