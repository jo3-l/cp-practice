package binarysearch;

public class EqualPartitions {
    private int[][] dp;

    public boolean solve(int[] nums) {
        int t = 0;
        for (int num : nums) t += num;
        if ((t & 1) == 1) return false;
        int h = t >> 1;
        dp = new int[nums.length][h + 1];
        return go(nums, 0, h);
    }

    private boolean go(int[] nums, int cur, int target) {
        if (target == 0) return true;
        if (target < 0 || cur == nums.length) return false;
        if (dp[cur][target] == 0) {
            dp[cur][target] = (go(nums, cur + 1, target)
                    || go(nums, cur + 1, target - nums[cur])) ? 1 : 2;
        }
        return dp[cur][target] == 1;
    }
}
