package binarysearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class IntervalUnion {
    public int[][] solve(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparing((int[] x) -> x[0]).thenComparing((int[] x) -> x[1]));
        List<int[]> xs = new ArrayList<>();
        int i = 0;
        while (i < intervals.length) {
            int[] b = intervals[i++];
            int[] m = {b[0], b[1]};
            while (i < intervals.length && overlaps(m, intervals[i])) {
                m[1] = Math.max(m[1], intervals[i++][1]);
            }
            xs.add(m);
        }

        int[][] res = new int[xs.size()][];
        for (int j = 0; j < xs.size(); j++) res[j] = xs.get(j);
        return res;
    }

    private boolean overlaps(int[] i0, int[] i1) {
        return (i0[0] >= i1[0] && i0[0] <= i1[1]) || (i1[0] >= i0[0] && i1[0] <= i0[1]);
    }
}
