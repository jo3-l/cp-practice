package binarysearch;

import java.util.Arrays;
import java.util.Comparator;

public class ContainedInterval {
    public boolean solve(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt((int[] x) -> x[0]).thenComparingInt(x -> x[1]));
        for (int i = 1; i < intervals.length; i++) {
            int[] curInterval = intervals[i];
            int[] lastInterval = intervals[i - 1];
            if (curInterval[0] == lastInterval[0] || curInterval[1] <= lastInterval[1]) return true;
        }
        return false;
    }
}
