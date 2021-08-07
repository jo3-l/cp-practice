package binarysearch;

public class LongestArithmeticSubsequence {
    public int solve(int[] nums) {
        if (nums.length < 2) return nums.length;
        int[][] dp = new int[nums.length][nums.length];
        int best = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                int want = nums[j] - nums[i] + nums[j];
                for (int z = 0; z < j; z++) {
                    if (nums[z] == want) {
                        dp[i][j] = Math.max(dp[i][j], dp[j][z] + 1);
                    }
                }
                best = Math.max(best, dp[i][j]);
            }
        }
        return best + 2;
    }
}
