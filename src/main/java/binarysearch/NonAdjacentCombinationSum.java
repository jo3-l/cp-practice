package binarysearch;

import java.util.Arrays;

public class NonAdjacentCombinationSum {
    public boolean solve(int[] nums, int k) {
        boolean[][] dp = new boolean[k + 1][nums.length]; // dp(k, i) = combo that sums up to k in nums[..i]
        Arrays.fill(dp[0], true);
        for (int i = 0; i <= k; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (j > 0) dp[i][j] = dp[i][j - 1];
                if (nums[j] <= i) {
                    dp[i][j] = dp[i][j] || i == nums[j] || (j >= 2 && dp[i - nums[j]][j - 2]);
                }
            }
        }
        return dp[k][nums.length - 1];
    }
}
