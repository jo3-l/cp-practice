package binarysearch;

import java.util.*;

public class MutualFollowers {
    public int[] solve(int[][] relations) {
        Set<Pair> pairs = new HashSet<>();
        for (int[] relation : relations) {
            pairs.add(new Pair(relation[0], relation[1]));
        }

        Set<Integer> mutuals = new HashSet<>();
        Pair p = new Pair(-1, -1);
        for (int[] relation : relations) {
            p.b = relation[0];
            p.a = relation[1];
            if (pairs.contains(p)) {
                mutuals.add(relation[0]);
                mutuals.add(relation[1]);
            }
        }

        int[] res = new int[mutuals.size()];
        int j = 0;
        for (int mutual : mutuals) res[j++] = mutual;
        Arrays.sort(res);
        return res;
    }

    public static class Pair {
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
            Pair cast = (Pair) obj;
            return cast.a == a && cast.b == b;
        }
    }
}
