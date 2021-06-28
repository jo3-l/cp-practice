package binarysearch;

import java.util.Arrays;

public class LowestSumOrPairLargerThanTarget {
    public int solve(int[] nums, int target) {
        Arrays.sort(nums);

        int best = Integer.MAX_VALUE;
        int hi = nums.length - 1;
        int lo = 0;
        while (lo < hi) {
            int s = nums[lo] + nums[hi];
            if (s > target) {
                best = Math.min(best, s);
                hi--;
            } else {
                lo++;
            }
        }
        return best;
    }
}
