package binarysearch;

import java.util.Arrays;

public class MinimizeAmplitudeAfterKRemovals {
    public int solve(int[] nums, int k) {
        Arrays.sort(nums);
        int r = Integer.MAX_VALUE;
        for (int i = 0; i <= k; i++) {
            int other = nums.length - k + i - 1;
            r = Math.min(r, nums[other] - nums[i]);
        }
        return r;
    }
}
