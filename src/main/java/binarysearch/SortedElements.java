package binarysearch;

import java.util.Arrays;

public class SortedElements {
    public int solve(int[] nums) {
        int[] sorted = new int[nums.length];
        System.arraycopy(nums, 0, sorted, 0, nums.length);
        Arrays.sort(sorted);

        int ok = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == sorted[i]) ok++;
        }
        return ok;
    }
}
