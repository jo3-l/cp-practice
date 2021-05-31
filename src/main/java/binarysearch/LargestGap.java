package binarysearch;

import java.util.Arrays;

public class LargestGap {
    public int solve(int[] nums) {
        Arrays.sort(nums);
        int best = -1;
        for (int i = 0; i < nums.length - 1; i++) {
            best = Math.max(best, nums[i + 1] - nums[i]);
        }
        return best;
    }
}
