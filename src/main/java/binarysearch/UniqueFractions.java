package binarysearch;

import java.util.*;

public class UniqueFractions {
    public int[][] solve(int[][] fractions) {
        Set<Pair> seen = new HashSet<>();
        Queue<int[]> q = new PriorityQueue<>(Comparator.comparing(v -> (float) v[0] / v[1]));
        for (int[] fraction : fractions) {
            int gcd = gcd(fraction[0], fraction[1]);
            if (gcd > 1) {
                fraction[0] /= gcd;
                fraction[1] /= gcd;
            }

            if (seen.add(new Pair(fraction[0], fraction[1]))) q.add(fraction);
        }

        int[][] r = new int[q.size()][];
        int i = 0;
        while (!q.isEmpty()) r[i++] = q.poll();
        return r;
    }

    private int gcd(int a, int b) {
        a = Math.abs(a);
        b = Math.abs(b);
        while (a != b) {
            if (a > b) {
                a -= b;
            } else {
                b -= a;
            }
        }

        return a;
    }

    private static class Pair {
        public int a;
        public int b;

        public Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public int hashCode() {
            return Objects.hash(a, b);
        }

        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof Pair)) return false;
            Pair p = (Pair) obj;
            return p.a == a && p.b == b;
        }
    }
}
