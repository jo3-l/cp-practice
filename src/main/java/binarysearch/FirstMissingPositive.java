package binarysearch;

import java.util.Arrays;

public class FirstMissingPositive {
    public int solve(int[] nums) {
        if (nums.length == 0) return 1;

        Arrays.sort(nums);
        int i = findFirstPositiveIndex(nums);
        if (i == -1 || nums[i] > 1) return 1;
        if (i == 0) i++;
        for (; i < nums.length; i++) {
            int prev = nums[i - 1];
            if (prev < 0 || prev == nums[i] - 1 || prev == nums[i]) continue;
            return prev + 1;
        }
        return nums[nums.length - 1] + 1;
    }

    private int findFirstPositiveIndex(int[] nums) {
        int lo = 0;
        int hi = nums.length - 1;
        while (lo < hi) {
            int mid = (lo + hi) >> 1;
            if (nums[mid] > 0) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }

        return nums[lo] > 0 ? lo : -1;
    }
}
