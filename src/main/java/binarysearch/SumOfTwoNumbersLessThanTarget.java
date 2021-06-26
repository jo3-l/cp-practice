package binarysearch;

import java.util.Arrays;

public class SumOfTwoNumbersLessThanTarget {
    public int solve(int[] nums, int target) {
        Arrays.sort(nums);
        int hi = nums.length - 1;
        int lo = 0;

        int best = Integer.MIN_VALUE;
        while (lo < hi) {
            int v = nums[lo] + nums[hi];
            if (v < target) {
                best = Math.max(best, v);
                lo++;
            } else {
                hi--;
            }
        }
        return best;
    }
}
