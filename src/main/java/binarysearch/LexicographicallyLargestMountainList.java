package binarysearch;

public class LexicographicallyLargestMountainList {
    public int[] solve(int n, int lower, int upper) {
        if (lower == upper) return new int[]{};
        // upper-m, upper-m+1, upper-m+2, ..., upper, upper-1, upper-2, ..., lower
        // we want to minimize m.
        int decrLen = upper - lower + 1;
        int incrLen = Math.max(1, n - decrLen);
        int[] xs = new int[n];
        int cur = upper - incrLen;
        for (int i = 0; i < n; i++) {
            if (i < incrLen) xs[i] = cur++;
            else if (i == incrLen) xs[i] = cur;
            else xs[i] = --cur;

            if (xs[i] < lower || xs[i] > upper) return new int[]{};
        }
        return xs;
    }
}
