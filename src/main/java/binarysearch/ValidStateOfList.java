package binarysearch;

public class ValidStateOfList {
    public boolean solve(int[] nums) {
        int N = nums.length;
        if (N < 2) return false;
        boolean[][] dp = new boolean[N][3];
        dp[1][0] = nums[0] == nums[1];
        for (int i = 2; i < N; i++) {
            dp[i][0] = nums[i] == nums[i - 1]
                    && (dp[i - 2][2] || dp[i - 2][1] || dp[i - 2][0]);
            dp[i][1] = nums[i] == nums[i - 1]
                    && nums[i] == nums[i - 2]
                    && (i < 3 || dp[i - 3][2] || dp[i - 3][1] || dp[i - 3][0]);
            dp[i][2] = nums[i] == nums[i - 1] + 1
                    && nums[i - 1] == nums[i - 2] + 1
                    && (i < 3 || dp[i - 3][2] || dp[i - 3][1] || dp[i - 3][0]);
        }
        return dp[N - 1][0] || dp[N - 1][1] || dp[N - 1][2];
    }
}
