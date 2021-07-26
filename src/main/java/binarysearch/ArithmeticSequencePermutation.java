package binarysearch;

import java.util.Arrays;

public class ArithmeticSequencePermutation {
    public boolean solve(int[] nums) {
        if (nums.length <= 2) return true;
        Arrays.sort(nums);
        int diff = nums[1] - nums[0];
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] != diff) return false;
        }
        return true;
    }
}
