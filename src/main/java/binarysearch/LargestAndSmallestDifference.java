package binarysearch;

import java.util.Arrays;

public class LargestAndSmallestDifference {
    public int solve(int[] nums, int k) {
        Arrays.sort(nums);
        int best = Integer.MAX_VALUE;
        // sliding window of length k
        for (int i = 0, j = k - 1; j < nums.length; i++, j++) {
            int max = nums[j];
            int min = nums[i];
            best = Math.min(best, max - min);
        }
        return best;
    }
}
