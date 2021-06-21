package binarysearch;

public class LongestIncreasingSubsequence {
    private int[][] dp;

    public int solve(int[] nums) {
        dp = new int[nums.length + 1][nums.length + 1];

        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, go(nums, i - 1, i));
        }
        return max;
    }

    private int go(int[] nums, int prevIdx, int curIdx) {
        if (curIdx >= nums.length) return 0;
        if (dp[prevIdx + 1][curIdx + 1] != 0) return dp[prevIdx + 1][curIdx + 1];
        int prevV = prevIdx != -1 ? nums[prevIdx] : Integer.MIN_VALUE;
        int curV = nums[curIdx];
        return dp[prevIdx + 1][curIdx + 1] = Math.max(
                // continue the sequence and add cur number
                prevV < curV
                        ? go(nums, curIdx, curIdx + 1) + 1
                        : Integer.MIN_VALUE,
                // continue the sequence and skip cur
                go(nums, prevIdx, curIdx + 1)
        );
    }
}
