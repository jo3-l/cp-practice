package binarysearch;

public class SubsequenceSum {
    public int solve(int[] nums) {
        int[] dp = new int[nums.length];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int n = dp[i] = nums[i];
            // want to choose nums[j] where it has a value of n - i + j
            for (int j = i - 1; j >= 0; j--) {
                if (nums[j] == n - i + j) {
                    dp[i] = Math.max(dp[i], dp[j] + nums[i]);
                    break;
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
