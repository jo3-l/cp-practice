package binarysearch;

import java.util.Arrays;

public class MedianMinimization {
    public int solve(int[] nums) {
        Arrays.sort(nums);
        int m = nums.length >> 1;
        return nums[m] - nums[m - 1];
    }
}
