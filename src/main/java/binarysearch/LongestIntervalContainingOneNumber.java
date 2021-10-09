package binarysearch;

import java.util.Arrays;

public class LongestIntervalContainingOneNumber {
    public int solve(int[] nums) {
        Arrays.sort(nums);
        int ms = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int hi = i < nums.length - 1 ? nums[i + 1] - 1 : 100_000;
            int lo = i > 0 ? nums[i - 1] + 1 : 1;
            if (lo <= nums[i] && nums[i] <= hi) ms = Math.max(ms, Math.abs(hi - lo) + 1);
        }
        return ms;
    }
}
