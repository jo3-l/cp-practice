package binarysearch;

public class MakeListsSameWithSublistSumOperations {
    public int solve(int[] l0, int[] l1) {
        for (int i = 1; i < l0.length; i++) l0[i] += l0[i - 1];
        for (int i = 1; i < l1.length; i++) l1[i] += l1[i - 1];

        int r = 0;
        int lo = 0;
        for (int x : l0) {
            int c = find(l1, x, lo);
            if (c != -1) {
                r++;
                lo = c + 1;
                if (lo >= l1.length) break;
            }
        }
        return r == 0 || lo < l1.length ? -1 : r;
    }

    private int find(int[] xs, int x, int lo) {
        int hi = xs.length - 1;
        int res = -1;
        while (lo <= hi) {
            int mid = (lo + hi) >>> 1;
            if (xs[mid] > x) hi = mid - 1;
            else if (xs[mid] == x) hi = (res = mid) - 1;
            else lo = mid + 1;
        }
        return res;
    }
}
