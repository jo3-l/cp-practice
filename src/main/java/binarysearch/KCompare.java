package binarysearch;

import java.util.Arrays;

public class KCompare {
    public int solve(int[] a, int[] b, int k) {
        Arrays.sort(a);
        Arrays.sort(b);

        int idx = b.length - k;
        int v = (idx >= 0 && idx < b.length) ? b[idx] : Integer.MAX_VALUE;

        int high = a.length - 1;
        int low = 0;
        while (low < high) {
            int mid = (low + high + 1) >> 1;
            if (a[mid] < v) {
                low = mid;
            } else {
                high = mid - 1;
            }
        }

        return low < a.length && a[low] < v
                ? low + 1
                : 0;
    }
}
