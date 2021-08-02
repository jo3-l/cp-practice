package binarysearch;

public class RectangularOverlap {
    public boolean solve(int[] rect0, int[] rect1) {
        return doIntervalsOverlap(rect0[0], rect0[2], rect1[0], rect1[2])
                && doIntervalsOverlap(rect0[1], rect0[3], rect1[1], rect1[3]);
    }

    private boolean doIntervalsOverlap(int l0, int r0, int l1, int r1) {
        return (l0 >= l1 && l0 < r1) || (l1 >= l0 && l1 < r0);
    }
}
