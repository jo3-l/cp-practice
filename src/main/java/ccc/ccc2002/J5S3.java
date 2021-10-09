package ccc.ccc2002;

import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.StringTokenizer;

public class J5S3 {
    public static void main(String[] args) {
        FastScanner sc = new FastScanner(System.in);
        FastOutputWriter out = new FastOutputWriter(System.out);
        List<State> states = new ArrayList<>();
        int R = sc.nextInt();
        int C = sc.nextInt();
        boolean[][] obstacles = new boolean[R][C];
        for (int i = 0; i < R; i++) {
            String s = sc.next();
            for (int j = 0; j < C; j++) {
                if (s.charAt(j) == 'X') {
                    obstacles[i][j] = true;
                } else {
                    for (Dir d : Dir.values()) states.add(new State(d, i, j));
                }
            }
        }

        int m = sc.nextInt();
        while (m-- > 0) {
            char mv = sc.next().charAt(0);
            ListIterator<State> iter = states.listIterator();
            while (iter.hasNext()) {
                State s = iter.next();
                if (mv == 'F') {
                    switch (s.dir) {
                        case N:
                            s.r--;
                            break;
                        case E:
                            s.c++;
                            break;
                        case S:
                            s.r++;
                            break;
                        case W:
                            s.c--;
                            break;
                    }

                    if (s.r < 0 || s.r >= R || s.c < 0 || s.c >= C || obstacles[s.r][s.c]) {
                        iter.remove();
                    }
                } else if (mv == 'L') {
                    //   N
                    // W   E
                    //   S
                    switch (s.dir) {
                        case N:
                            s.dir = Dir.W;
                            break;
                        case E:
                            s.dir = Dir.N;
                            break;
                        case S:
                            s.dir = Dir.E;
                            break;
                        case W:
                            s.dir = Dir.S;
                            break;
                    }
                } else if (mv == 'R') {
                    switch (s.dir) {
                        case N:
                            s.dir = Dir.E;
                            break;
                        case E:
                            s.dir = Dir.S;
                            break;
                        case S:
                            s.dir = Dir.W;
                            break;
                        case W:
                            s.dir = Dir.N;
                            break;
                    }
                }
            }
        }

        boolean[][] end = new boolean[R][C];
        for (State s : states) {
            end[s.r][s.c] = true;
        }
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (obstacles[i][j]) out.print('X');
                else if (end[i][j]) out.print('*');
                else out.print('.');
            }
            out.println();
        }

        out.close();
    }

    private static class State {
        public Dir dir;
        public int r;
        public int c;

        public State(Dir dir, int r, int c) {
            this.dir = dir;
            this.r = r;
            this.c = c;
        }
    }

    private enum Dir {N, E, S, W}

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