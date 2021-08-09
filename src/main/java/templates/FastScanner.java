package templates;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// fast i/o using BufferedReader and StringTokenizer
// NOTE: use BufferedWriter for fast output (remember to flush())
public class FastScanner {
    public StringTokenizer st;
    public BufferedReader br;

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