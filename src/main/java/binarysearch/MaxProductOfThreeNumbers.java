package binarysearch;

import java.util.Arrays;

public class MaxProductOfThreeNumbers {
    public int solve(int[] nums) {
        Arrays.sort(nums);
        int N = nums.length;
        return Math.max(nums[N - 1] * nums[N - 2] * nums[N - 3], nums[0] * nums[1] * nums[N - 1]);
    }
}
