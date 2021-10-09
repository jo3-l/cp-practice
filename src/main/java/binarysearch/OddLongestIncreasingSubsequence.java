package binarysearch;

public class OddLongestIncreasingSubsequence {
    public int solve(int[] nums, int k) {
        final int OVERFLOW = k + 1; // dp(i, OVERFLOW) = longest increasing subsequence ending at i with > k odd nums
        int[][] dp = new int[nums.length][k + 2];
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j <= k + 1; j++) {
                if ((nums[i] & 1) == 1) {
                    // odd number
                    if (j == 0) continue;
                    int longest = 0;
                    for (int z = 0; z < i; z++) {
                        if (nums[i] > nums[z]) longest = Math.max(longest, j == OVERFLOW ? Math.max(dp[z][j], dp[z][j - 1]) : dp[z][j - 1]);
                    }
                    if (longest != 0 || j == 1) dp[i][j] = longest + 1;
                } else {
                    // even number
                    int longest = 0;
                    for (int z = 0; z < i; z++) {
                        if (nums[i] > nums[z]) longest = Math.max(longest, dp[z][j]);
                    }
                    if (longest != 0 || j == 0) dp[i][j] = longest + 1;
                }

                if (j >= k) res = Math.max(res, dp[i][j]);
            }
        }
        return res;
    }
}
