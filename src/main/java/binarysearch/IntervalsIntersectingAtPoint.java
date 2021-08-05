package binarysearch;

public class IntervalsIntersectingAtPoint {
    public int solve(int[][] intervals, int point) {
        int n = 0;
        for (int[] i : intervals) if (point >= i[0] && point <= i[1]) n++;
        return n;
    }
}
