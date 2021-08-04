package binarysearch;

public class IncreasingSubsequencesOfSizeK {
    public int solve(int[] nums, int k) {
        final int MOD = (int) 1e9 + 7;
        if (nums.length == 0) return 0;

        int res = 0;
        int[][] dp = new int[nums.length][k + 1];
        for (int i = 0; i < nums.length; i++) {
            dp[i][1] = 1;
            for (int s = 2; s <= k; s++) {
                for (int j = 0; j < i; j++) {
                    if (nums[j] < nums[i]) {
                        dp[i][s] += dp[j][s - 1];
                        dp[i][s] %= MOD;
                    }
                }
            }
            res += dp[i][k];
            res %= MOD;
        }
        return res;
    }
}
