package binarysearch;

public class WolfOfWallStreet {
    public int solve(int[] prices) {
        if (prices.length < 2) return 0;
        int[] max = new int[prices.length];
        max[prices.length - 1] = prices[prices.length - 1];
        for (int p = prices.length - 2; p >= 0; p--) {
            max[p] = Math.max(max[p + 1], prices[p]);
        }

        int best = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            best = Math.max(best, max[i + 1] - prices[i]);
        }
        return best;
    }
}
