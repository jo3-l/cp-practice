package ccc.ccc2005;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class S4 {
    public static void main(String[] args) {
        FastScanner sc = new FastScanner(System.in);
        int L = sc.nextInt();
        while (L-- > 0) {
            int n = sc.nextInt();
            String[] messages = new String[n];
            for (int i = 0; i < n; i++) messages[i] = sc.nextLine();

            // last message recipient is the root.
            String rootName = messages[n - 1];
            Map<String, List<String>> zombies = new HashMap<>();

            zombies.put(rootName, new ArrayList<>());
            List<String> stack = new ArrayList<>();
            stack.add(rootName);
            for (String name : messages) {
                String parent = stack.remove(stack.size() - 1);
                if (!zombies.containsKey(name) || !zombies.get(name).contains(parent)) {
                    zombies.computeIfAbsent(parent, k -> new ArrayList<>()).add(name);
                }
                stack.add(name);
            }

            int oldTime = n * 10;
            int newTime = (getMaxDepth(rootName, zombies) << 1) * 10;
            System.out.println(oldTime - newTime);
        }
    }

    private static int getMaxDepth(String name, Map<String, List<String>> zombies) {
        List<String> children = zombies.get(name);
        if (children == null) return 0;
        int max = 0;
        for (String child : children) max = Math.max(getMaxDepth(child, zombies), max);
        return max + 1;
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