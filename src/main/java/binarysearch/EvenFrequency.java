package binarysearch;

import java.util.Arrays;

public class EvenFrequency {
    public boolean solve(int[] nums) {
        Arrays.sort(nums);
        int i = 0;
        while (i < nums.length) {
            int j = idx(nums, nums[i]);
            if (((j - i) & 1) == 1) return false;
            i = j;
        }
        return true;
    }

    private int idx(int[] nums, int num) {
        int hi = nums.length - 1;
        int lo = 0;
        while (lo < hi) {
            int mid = (lo + hi) >> 1;
            if (nums[mid] > num) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return nums[lo] > num ? lo : nums.length;
    }
}
