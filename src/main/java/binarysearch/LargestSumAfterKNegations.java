package binarysearch;

import java.util.Arrays;

public class LargestSumAfterKNegations {
    public int solve(int[] nums, int k) {
        if (nums.length == 0) return 0;

        Arrays.sort(nums);
        int neg = countNegativeNums(nums);
        if (neg >= k) {
            int sum = 0;
            for (int i = 0; i < nums.length; i++) {
                sum += i < k ? -nums[i] : nums[i];
            }
            return sum;
        }

        int leftover = k - neg;
        if ((leftover & 1) == 0) {
            if (neg == nums.length) {
                // all negative numbers; invert all but the greatest
                int sum = 0;
                for (int i = 0; i < nums.length; i++) {
                    sum += i == nums.length - 1 ? nums[i] : -nums[i];
                }
                return sum;
            }

            // combination of negative and non-negative numbers; invert all negative numbers
            // but keep positive numbers as-is
            int sum = 0;
            for (int i = 0; i < nums.length; i++) {
                sum += i < neg ? -nums[i] : nums[i];
            }
            return sum;
        }

        // odd number of inversions left.
        // invert all negative numbers in addition to either:
        //  1. keeping the greatest negative number as-is
        //  2. inverting the smallest non-negative number
        int sum = 0;
        int maxNegAbs = Integer.MAX_VALUE;
        int minNonNeg = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (i < neg) {
                sum += -nums[i];
                maxNegAbs = maxNegAbs == Integer.MAX_VALUE
                        ? -nums[i]
                        : Math.min(maxNegAbs, -nums[i]);
            } else {
                sum += nums[i];
                minNonNeg = Math.min(minNonNeg, nums[i]);
            }
        }
        return sum - (2 * Math.min(maxNegAbs, minNonNeg));
    }

    private int countNegativeNums(int[] nums) {
        int lo = 0;
        int hi = nums.length - 1;
        while (lo < hi) {
            int mid = (lo + hi + 1) >> 1;
            if (nums[mid] < 0) {
                lo = mid;
            } else {
                hi = mid - 1;
            }
        }
        return nums[lo] < 0 ? lo + 1 : 0;
    }
}
