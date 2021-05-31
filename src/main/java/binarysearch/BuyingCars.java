package binarysearch;

import java.util.Arrays;

public class BuyingCars {
    public int solve(int[] prices, int k) {
        Arrays.sort(prices);
        int total = 0;

        int i;
        for (i = 0; i < prices.length; i++) {
            total += prices[i];
            if (total > k) break;
        }

        return i;
    }
}
