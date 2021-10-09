package binarysearch;

import java.util.Arrays;
import java.util.Comparator;

public class MinimumSizeOfTwoNonOverlappingIntervals {
    public int solve(int[][] intervals) {
        if (intervals.length == 0) return 0;
        Arrays.sort(intervals, Comparator.comparing(i -> i[0]));
        int[] mr = new int[intervals.length]; // mr[i] = min(sizes[i..])
        int[] li = intervals[intervals.length - 1];
        mr[intervals.length - 1] = li[1] - li[0] + 1;
        for (int i = intervals.length - 2; i >= 0; i--) {
            mr[i] = Math.min(intervals[i][1] - intervals[i][0] + 1, mr[i + 1]);
        }

        int r = Integer.MAX_VALUE;
        for (int i = 0; i < intervals.length; i++) {
            int[] in = intervals[i];
            int j = find(intervals, in);
            if (j != -1 && j != i) {
                r = Math.min(r, in[1] - in[0] + 1 + mr[j]);
            }
        }
        return r == Integer.MAX_VALUE ? 0 : r;
    }

    private int find(int[][] intervals, int[] interval) {
        int end = interval[1];
        // find lowest interval where start > end
        int lo = 0;
        int hi = intervals.length - 1;
        while (lo < hi) {
            int mid = (lo + hi) >> 1;
            if (intervals[mid][0] > end) hi = mid;
            else lo = mid + 1;
        }
        return intervals[lo][0] > end ? lo : -1;
    }
}
