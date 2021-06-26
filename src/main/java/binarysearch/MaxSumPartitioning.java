package binarysearch;

public class MaxSumPartitioning {
    private int[] dp;

    public int solve(int[] nums, int k) {
        dp = new int[nums.length];
        return go(nums, k, 0);
    }

    private int go(int[] nums, int k, int idx) {
        if (idx == nums.length) return 0;
        if (dp[idx] != 0) return dp[idx];
        int mark = idx;

        int max = Integer.MIN_VALUE;
        int best = Integer.MIN_VALUE;
        int len = 1;
        while (idx < nums.length && len <= k) {
            max = Math.max(max, nums[idx++]);
            best = Math.max(best, (max * len++) + go(nums, k, idx));
        }
        return dp[mark] = best;
    }
}
