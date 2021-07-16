package cses;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class PalindromeReorder {
    public static void main(String[] args) {
        FastScanner sc = new FastScanner(System.in);
        String s = sc.nextLine();
        int[] counts = new int[26];
        for (int i =0; i < s.length(); i++) counts[s.charAt(i) - 'A']++;
        char[] mk = new char[s.length()];
        int lo = 0;
        int hi = s.length() - 1;
        boolean seenOdd = false;
        for (int i = 0; i < 26; i++) {
            char x = (char) ('A' + i);
            int v = counts[i];
            if (v == 0) continue;
            if ((v & 1) == 1) {
                if (seenOdd || (s.length() & 1) == 0) {
                    System.out.println("NO SOLUTION");
                    return;
                }
                seenOdd = true;
                int m = s.length() >> 1;
                mk[m] = x;
                if (v > 1) {
                    int l = m - 1;
                    int r = m + 1;
                    for (v--; v != 0; v -= 2) mk[l--] = mk[r++] = x;
                }
            } else {
                for (; v != 0; v -= 2) mk[lo++] = mk[hi--] = x;
            }
        }
        System.out.println(new String(mk));
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