package binarysearch;

public class WolvesOfWallStreet {
    public int solve(int[] prices) {
        int n = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            n += Math.max(prices[i + 1] - prices[i], 0);
        }
        return n;
    }
}
