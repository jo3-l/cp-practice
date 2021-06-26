package binarysearch;

public class LargestSumOfNonAdjacentNumbers {
    private int[] dp;

    public int solve(int[] nums) {
        dp = new int[nums.length];
        return go(nums, 0);
    }

    private int go(int[] nums, int idx) {
        if (idx >= nums.length) return 0;
        if (dp[idx] != 0) return dp[idx];
        return dp[idx] = Math.max(
                // skip current number
                go(nums, idx + 1),
                // choose next number
                nums[idx] + go(nums, idx + 2)
        );
    }
}
