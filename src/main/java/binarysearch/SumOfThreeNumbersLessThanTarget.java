package binarysearch;

import java.util.Arrays;

public class SumOfThreeNumbersLessThanTarget {
    public int solve(int[] nums, int target) {
        Arrays.sort(nums);
        int res = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            int max = target - nums[i]; // exclusive
            int hi = nums.length - 1;
            int lo = i + 1;
            while (lo < hi) {
                int x = nums[lo] + nums[hi];
                if (x < max) {
                    res += hi - lo;
                    lo++;
                } else {
                    hi--;
                }
            }
        }
        return res;
    }
}
