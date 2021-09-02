package binarysearch;

public class EatBananasInKHours {
    public int solve(int[] piles, int k) {
        int l = 0;
        int r = Integer.MAX_VALUE;
        while (l < r) {
            int m = (l + r) >>> 1;
            if (attempt(piles, m, k)) r = m;
            else l = m + 1;
        }
        return l;
    }

    private boolean attempt(int[] piles, int r, int k) {
        int j = 0;
        for (int v : piles) {
            j += Math.ceil(v / (float) r);
            if (j > k) return false;
        }
        return j <= k;
    }
}
