package binarysearch;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class NumberOfIslandsOnline {
    public int[] solve(int[][] reqs) {
        DSU dsu = new DSU();
        int[] res = new int[reqs.length];
        for (int i = 0; i < reqs.length; i++) {
            int[] req = reqs[i];
            dsu.mk(new P(req[0], req[1]));
            res[i] = dsu.comps;
        }
        return res;
    }

    private static class DSU {
        private final int[] dr = {1, -1, 0, 0};
        private final int[] dc = {0, 0, -1, 1};
        private Map<P, P> par = new HashMap<>();
        private Map<P, Integer> sz = new HashMap<>();
        public int comps = 0;

        public void mk(P p) {
            comps++;
            par.put(p, p);
            sz.put(p, 1);
            for (int d = 0; d < 4; d++) {
                int nr = p.r + dr[d];
                int nc = p.c + dc[d];
                if (nr >= 0 && nc >= 0) {
                    P np = new P(nr, nc);
                    if (par.containsKey(np)) union(p, new P(nr, nc));
                }
            }
        }

        public P find(P p) {
            P pp = par.get(p);
            if (pp.equals(p)) return pp;
            P ppp = find(pp);
            par.put(p, ppp);
            return ppp;
        }

        public void union(P a, P b) {
            a = find(a);
            b = find(b);
            if (a.equals(b)) return;
            comps--;
            if (sz.get(a) > sz.get(b)) {
                P t = a;
                a = b;
                b = t;
            }
            sz.merge(a, sz.get(b), Integer::sum);
            par.put(b, a);
        }
    }

    private static class P {
        int r;
        int c;
        P(int r, int c) {
            this.r = r;
            this.c =c ;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            P p = (P) o;
            return r == p.r && c == p.c;
        }

        @Override
        public int hashCode() {
            return Objects.hash(r, c);
        }
    }
}
