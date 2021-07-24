package binarysearch;

import java.util.Arrays;

public class MinimumCostSort {
    public int solve(int[] nums) {
        int[] sorted = Arrays.copyOf(nums, nums.length);
        Arrays.sort(sorted);
        int diffA = 0;
        int diffB = 0;
        for (int i = 0; i < nums.length; i++) {
            diffA += Math.abs(nums[i] - sorted[i]);
            diffB += Math.abs(nums[nums.length - i - 1] - sorted[i]);
        }
        return Math.min(diffA, diffB);
    }
}
