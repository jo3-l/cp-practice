package binarysearch;

import java.util.Arrays;

public class ListEqualityWithIncrements {
    public int solve(int[] nums) {
        if (nums.length < 2) return 0;
        Arrays.sort(nums);
        int ops = 0;
        for (int i = nums.length - 1; i >= 1; i--) {
            if (nums[i] > nums[i - 1]) {
                ops += (nums[i] - nums[i - 1]) * (nums.length - i);
                nums[i] = nums[i - 1];
            }
        }
        return ops;
    }
}
