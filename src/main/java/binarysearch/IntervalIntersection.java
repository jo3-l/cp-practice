package binarysearch;

public class IntervalIntersection {
    public int[] solve(int[][] intervals) {
        int[] ret = {Integer.MIN_VALUE, Integer.MAX_VALUE};
        for (int[] i : intervals) {
            ret[0] = Math.max(ret[0], i[0]);
            ret[1] = Math.min(ret[1], i[1]);
        }
        return ret;
    }
}
