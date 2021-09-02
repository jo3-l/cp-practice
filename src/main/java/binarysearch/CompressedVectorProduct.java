package binarysearch;

public class CompressedVectorProduct {
    public int solve(int[] a, int[] b) {
        int res = 0;
        int aCount = a[0];
        int aIdx = 0;
        int bCount = b[0];
        int bIdx = 0;
        while (aIdx < a.length && bIdx < b.length) {
            if (aCount <= bCount) {
                res += (a[aIdx + 1] * b[bIdx + 1]) * aCount;
                bCount -= aCount;
                aIdx += 2;
                if (aIdx < a.length) aCount = a[aIdx];
            } else {
                res += (a[aIdx + 1] * b[bIdx + 1]) * bCount;
                aCount -= bCount;
                bIdx += 2;
                if (bIdx < b.length) bCount = b[bIdx];
            }
        }
        return res;
    }
}
