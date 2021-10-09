package binarysearch;

import java.util.Arrays;

public class LegoTowers {
    public int solve(int[] heights, int k) {
        if (heights.length == 0) return 0;
        Arrays.sort(heights);
        int best = Integer.MAX_VALUE;
        int cost = 0;
        for (int i = 0, j = k - 1; j < heights.length; i++, j++) {
            if (i == 0) {
                for (int z = 0; z < j; z++) cost += heights[j] - heights[z];
                best = cost;
            } else {
                // remove cost associated with element i-1
                cost -= heights[j - 1] - heights[i - 1];
                // update cost to use j as max element instead of j-1
                cost += (k - 1) * (heights[j] - heights[j - 1]);
                best = Math.min(best, cost);
            }
        }
        return best;
    }
}
