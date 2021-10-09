package binarysearch;

public class LongestBitonicSubsequence {
    public int solve(int[] nums) {
        // dp[i][j][k] is the longest bitonic subsequence ending at nums[i]. j specifies whether the
        // sort order changed once already; k specifies the previous sort order (0 for increasing, 1 for decreasing).
        int[][][] dp = new int[nums.length][2][2];
        dp[0][0][0] = dp[0][0][1] = 1;
        int max = 0;
        for (int i = 1; i < nums.length; i++) {
            dp[i][0][0] = dp[i][0][1] = 1; // can always start a new sequence
            for (int j = 0; j < i; j++) {
                if (nums[i] < nums[j]) { // decreasing
                    // sort order already changed and is decreasing
                    dp[i][1][1] = Math.max(dp[i][1][1], dp[j][1][1] + 1);
                    // sort order has not changed yet and is still decreasing
                    dp[i][0][1] = Math.max(dp[i][0][1], dp[j][0][1] + 1);
                    // sort order has not changed yet and was increasing before but is now decreasing
                    dp[i][1][1] = Math.max(dp[i][1][1], dp[j][0][0] + 1);
                } else if (nums[i] > nums[j]) { // increasing
                    // sort order has not changed yet and is increasing
                    dp[i][0][0] = Math.max(dp[i][0][0], dp[j][0][0] + 1);
                }
            }

            max = Math.max(max, Math.max(Math.max(dp[i][0][0], dp[i][0][1]), Math.max(dp[i][1][0], dp[i][1][1])));
        }

        return max;
    }
}
