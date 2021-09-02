package binarysearch;

import java.util.Arrays;
import java.util.Comparator;

public class FlightScheduling {
    public int solve(int[][] costs) {
        return Math.min(cmp(costs, 0), cmp(costs, 1));
    }

    private int cmp(int[][] costs, int f) {
        E[] xs = new E[costs.length];
        for (int i = 0; i < costs.length; i++) xs[i] = new E(costs[i], i);
        Arrays.sort(xs, Comparator.comparing((E v) -> v.v[f]).thenComparing((E v) -> v.v[f ^ 1]));
        int c = 0;
        boolean[] use = new boolean[costs.length];
        for (int i = 0; i < xs.length >> 1; i++) {
            c += xs[i].v[f];
            use[xs[i].idx] = true;
        }
        for (E e : xs) {
            if (!use[e.idx]) c += e.v[f ^ 1];
        }
        return c;
    }

    private static class E {
        public int[] v;
        public int idx;
        public E(int[] v, int idx) {
            this.v = v;
            this.idx = idx;
        }
    }
}
