package ccc.ccc2007;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S2 {
    public static void main(String[] args) {
        FastScanner sc = new FastScanner(System.in);
        int n = sc.nextInt();
        Box[] boxes = new Box[n];
        for (int i = 0; i < n; i++) boxes[i] = new Box(sc.nextInt(), sc.nextInt(), sc.nextInt());
        int m = sc.nextInt();
        while (m-- > 0) {
            Box cur = new Box(sc.nextInt(), sc.nextInt(), sc.nextInt());
            int minVol = Integer.MAX_VALUE;
            for (Box box : boxes) {
                if (cur.fitsIn(box)) minVol = Math.min(minVol, box.vol);
            }
            System.out.println(minVol == Integer.MAX_VALUE ? "Item does not fit." : minVol);
        }
    }

    private static class Box {
        public int l;
        public int w;
        public int h;
        public int vol;

        public Box(int l, int w, int h) {
            this.l = l;
            this.w = w;
            this.h = h;
            vol = l * w * h;
        }

        public boolean fitsIn(Box parent) {
            return
                    (parent.l >= l && parent.w >= w && parent.h >= h)
                    || (parent.l >= l && parent.w >= h && parent.h >= w)
                    || (parent.l >= w && parent.w >= l && parent.h >= h)
                    || (parent.l >= w && parent.w >= h && parent.h >= l)
                    || (parent.l >= h && parent.w >= l && parent.h >= w)
                    || (parent.l >= h && parent.w >= w && parent.h >= l)
            ;
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