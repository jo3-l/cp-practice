package binarysearch;

import java.util.Arrays;

public class KNumbersGreaterThanOrEqualToK {
    public int solve(int[] nums) {
        Arrays.sort(nums);
        for (int i = nums.length - 1; i >= 0; i--) {
            int v = nums[i];
            int k = nums.length - i;
            if (v == k && (i == 0 || nums[i - 1] != v)) return k;
            if (i == 0) break;
            int next = nums[i - 1];
            if (k < v && k > next) return k;
        }
        return -1;
    }
}
