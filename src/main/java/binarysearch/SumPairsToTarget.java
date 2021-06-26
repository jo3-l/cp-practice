package binarysearch;

import java.util.Arrays;

public class SumPairsToTarget {
    public int solve(int[] nums, int target) {
        Arrays.sort(nums);
        int N = 0;
        int hi = nums.length - 1;
        int lo = 0;
        while (lo < hi) {
            int sum = nums[lo] + nums[hi];
            if (sum > target) {
                hi--;
            } else if (sum == target) {
                N++;
                lo++;
                hi--;
            } else {
                // sum < target
                lo++;
            }
        }
        return N;
    }
}
