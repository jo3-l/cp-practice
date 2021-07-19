package binarysearch;

public class LongestAlternatingSubsequence {
    public int solve(int[] nums) {
        if (nums.length == 0) return 0;
        // dp[i][j] => longest subsequence ending at index i. if j == 0, the last difference was positive; otherwise, it was negative.
        int[][] dp = new int[nums.length][2];
        dp[0][0] = dp[0][1] = 1;
        for (int i = 1; i < nums.length; i++) {
            int cur = nums[i];
            for (int j = 0; j < i; j++) {
                int prev = nums[j];
                if (cur == prev) continue;
                int sign = cur > prev ? 0 : 1;
                dp[i][sign] = Math.max(dp[i][sign], dp[j][sign ^ 1] + 1);
            }
        }
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(dp[i][0], max);
            max = Math.max(dp[i][1], max);
        }
        return max;
    }
}
