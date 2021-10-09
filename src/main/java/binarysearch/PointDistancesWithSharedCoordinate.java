package binarysearch;

import java.util.*;

public class PointDistancesWithSharedCoordinate {
    public int[] solve(int[][] points) {
        Map<Integer, List<Integer>> ys = new HashMap<>(); // y => list of x
        Map<Integer, List<Integer>> xs = new HashMap<>(); // x => list of y
        for (int[] p : points) {
            xs.computeIfAbsent(p[0], k -> new ArrayList<>()).add(p[1]);
            ys.computeIfAbsent(p[1], k -> new ArrayList<>()).add(p[0]);
        }

        for (List<Integer> v : ys.values()) v.sort(Comparator.naturalOrder());
        for (List<Integer> v : xs.values()) v.sort(Comparator.naturalOrder());

        int[] res = new int[points.length];
        for (int i = 0; i < points.length; i++) {
            res[i] = Integer.MAX_VALUE;
            int[] p = points[i];
            List<Integer> sameX = xs.get(p[0]);
            if (sameX != null) {
                int lo = findLt(sameX, p[1]);
                int hi = findGt(sameX, p[1]);
                if (lo != -1) res[i] = Math.min(res[i], Math.abs(p[1] - sameX.get(lo)));
                if (hi != -1) res[i] = Math.min(res[i], Math.abs(p[1] - sameX.get(hi)));
            }
            List<Integer> sameY = ys.get(p[1]);
            if (sameY != null) {
                int lo = findLt(sameY, p[0]);
                int hi = findGt(sameY, p[0]);
                if (lo != -1) res[i] = Math.min(res[i], Math.abs(p[0] - sameY.get(lo)));
                if (hi != -1) res[i] = Math.min(res[i], Math.abs(p[0] - sameY.get(hi)));
            }
        }
        return res;
    }

    private int findGt(List<Integer> xs, int x) {
        int lo = 0;
        int hi = xs.size() - 1;
        while (lo < hi) {
            int mid = (lo + hi) >> 1;
            if (xs.get(mid) > x) hi = mid;
            else lo = mid + 1;
        }
        return xs.get(lo) > x ? lo : -1;
    }

    private int findLt(List<Integer> xs, int x) {
        int lo = 0;
        int hi = xs.size() - 1;
        while (lo < hi) {
            int mid = (lo + hi + 1) >> 1;
            if (xs.get(mid) < x) lo = mid;
            else hi = mid - 1;
        }
        return xs.get(lo) < x ? lo : -1;
    }
}
