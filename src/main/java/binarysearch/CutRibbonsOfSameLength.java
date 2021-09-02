package binarysearch;

public class CutRibbonsOfSameLength {
    public int solve(int[] ribbons, int k) {
        int lo = 0;
        int hi = Integer.MAX_VALUE;
        int res = -1;
        while (lo < hi) {
            int mid = (lo + hi + 1) >>> 1;
            if (cmp(ribbons, mid) >= k) lo = res = mid;
            else hi = mid - 1;
        }
        return res;
    }

    private int cmp(int[] ribbons, int r) {
        int j = 0;
        for (int v : ribbons) j += v / r;
        return j;
    }
}
