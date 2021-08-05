package binarysearch;

import java.util.Arrays;
import java.util.Comparator;

public class JobSchedulingToMaximizeProfit {
    public int solve(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparing(i -> i[0]));
        int[] dp = new int[intervals.length];
        int re = 0;
        for (int i = 0; i < intervals.length; i++) {
            dp[i] = intervals[i][2];
            for (int j = 0; j < i; j++) {
                if (!overlaps(intervals[i][0], intervals[i][1], intervals[j][0], intervals[j][1])) {
                    dp[i] = Math.max(dp[i], dp[j] + intervals[i][2]);
                }
            }
            re = Math.max(re, dp[i]);
        }
        return re;
    }

    private boolean overlaps(int s0, int f0, int s1, int f1) {
        return (s0 >= s1 && s0 < f1) || (s1 >= s0 && s1 < f0);
    }
}
