package cses;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MissingNumber {
    public static void main(String[] args) throws IOException {
        int N = FastReader.nextInt();
        long t = ((long) N * (N + 1)) >> 1;
        for (int i = 0; i < N - 1; i++) {
            int n = FastReader.nextInt();
            t -= n;
        }
        System.out.println(t);
    }

    public static class FastReader {
        private static StringTokenizer st;
        private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        public static String nextLine() throws IOException {
            return br.readLine();
        }

        public static int nextInt() throws IOException {
            if (st == null || !st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            boolean neg = s.charAt(0) == '-';
            int n = 0;
            for (int i = neg ? 1 : 0; i < s.length(); i++) {
                n *= 10;
                n += s.charAt(i) - '0';
            }
            return neg ? -n : n;
        }

        public static long nextLong() throws IOException {
            if (st == null || !st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            boolean neg = s.charAt(0) == '-';
            long n = 0;
            for (int i = neg ? 1 : 0; i < s.length(); i++) {
                n *= 10;
                n += s.charAt(i) - '0';
            }
            return n;
        }

        public static float nextFloat() throws IOException {
            if (st == null || !st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
            return Float.parseFloat(st.nextToken());
        }

        public static double nextDouble() throws IOException {
            if (st == null || !st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
            return Double.parseDouble(st.nextToken());
        }

        public static String next() throws IOException {
            if (st == null || !st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
            return st.nextToken();
        }
    }
}