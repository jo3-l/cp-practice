package binarysearch;

public class Skydivers {
    public int solve(int[] requests, int k) {
        int lo = 0;
        int hi = Integer.MAX_VALUE;
        while (lo < hi) {
            int size = lo + (hi - lo) / 2;
            if (canFulfill(requests, k, size)) {
                hi = size;
            } else {
                lo = size + 1;
            }
        }
        return canFulfill(requests, k, lo) ? lo : -1;
    }

    private boolean canFulfill(int[] requests, int k, int size) {
        int j = 0;
        for (int i = 0; i < k; i++) {
            int p = 0;
            while (j < requests.length && p <= size) {
                p += requests[j++];
            }

            if (p > size) j--;
            if (j >= requests.length) return true;
        }
        return false;
    }
}
