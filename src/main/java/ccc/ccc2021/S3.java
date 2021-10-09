package ccc.ccc2021;

import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class S3 {
    public static void main(String[] args) {
        FastScanner sc = new FastScanner(System.in);
        FastOutputWriter out = new FastOutputWriter(System.out);
        int n = sc.nextInt();
        Person[] people = new Person[n];
        int lloc = Integer.MAX_VALUE;
        int hloc = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            people[i] = new Person(sc.nextInt(), sc.nextInt(), sc.nextInt());
            lloc = Math.min(lloc, people[i].loc);
            hloc = Math.max(hloc, people[i].loc);
        }

        if (lloc == hloc) {
            out.println(0);
            out.close();
            return;
        }

        long res = -1;
        int lo = lloc;
        int hi = hloc;
        while (lo < hi) {
            int mid = lo + (hi - lo + 1) / 2;
            long r = cmp(mid - 1, people);
            long l = cmp(mid, people);
            if (l < r) {
                res = l;
                lo = mid;
            } else {
                hi = mid - 1;
            }
        }
        out.println(res);
        out.close();
    }

    private static long cmp(int l, Person[] people) {
        long ldist = 0;
        for (Person p : people) {
            long walk = 0;
            if (p.loc < l) {
                int d = l - p.hrd;
                if (p.loc < d) {
                    walk = (long) (d - p.loc) * p.wspeed;
                }
            } else if (p.loc > l) {
                int d = l + p.hrd;
                if (d < p.loc) {
                    walk = (long) (p.loc - d) * p.wspeed;
                }
            }
            ldist += walk;
        }
        return ldist;
    }

    private static class Person {
        public int loc;
        public int wspeed;
        public int hrd;

        public Person(int loc, int wspeed, int hrd) {
            this.loc = loc;
            this.wspeed = wspeed;
            this.hrd = hrd;
        }
    }

    public static class FastOutputWriter {
        public BufferedWriter wr;

        public FastOutputWriter(OutputStream st) {
            wr = new BufferedWriter(new OutputStreamWriter(st));
        }

        public void println(boolean b) {
            try {
                wr.write(String.valueOf(b));
                wr.write('\n');
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        public void println(char c) {
            try {
                wr.write(String.valueOf(c));
                wr.write('\n');
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        public void println(int i) {
            try {
                wr.write(String.valueOf(i));
                wr.write('\n');
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        public void println(long l) {
            try {
                wr.write(String.valueOf(l));
                wr.write('\n');
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        public void println(float f) {
            try {
                wr.write(String.valueOf(f));
                wr.write('\n');
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        public void println(double d) {
            try {
                wr.write(String.valueOf(d));
                wr.write('\n');
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        public void println(String s) {
            try {
                wr.write(String.valueOf(s));
                wr.write('\n');
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        public void println(char[] cs) {
            try {
                wr.write(cs);
                wr.write('\n');
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        public void println(Object o) {
            try {
                wr.write(String.valueOf(o));
                wr.write('\n');
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        public void println() {
            try {
                wr.write('\n');
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        public void print(boolean b) {
            try {
                wr.write(String.valueOf(b));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        public void print(char c) {
            try {
                wr.write(String.valueOf(c));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        public void print(int i) {
            try {
                wr.write(String.valueOf(i));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        public void print(long l) {
            try {
                wr.write(String.valueOf(l));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        public void print(float f) {
            try {
                wr.write(String.valueOf(f));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        public void print(double d) {
            try {
                wr.write(String.valueOf(d));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        public void print(String s) {
            try {
                wr.write(String.valueOf(s));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        public void print(char[] cs) {
            try {
                wr.write(cs);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        public void print(Object o) {
            try {
                wr.write(String.valueOf(o));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        public void flush() {
            try {
                wr.flush();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        public void close() {
            try {
                wr.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }


    public static class FastScanner {
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
                throw new RuntimeException(e);
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
                    throw new RuntimeException(e);
                }
            }
            return st.nextToken();
        }
    }
}