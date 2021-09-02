package binarysearch;

import java.util.Arrays;

public class MinimumDifferenceOfExtremes {
    public int solve(int[] nums) {
        if (nums.length <= 3) return 0;
        Arrays.sort(nums);
        // 1. upd max 0, min 3
        int a = nums[nums.length - 1] - nums[3];
        // 2. upd max 1, min 2
        int b = nums[nums.length - 2] - nums[2];
        // 3. upd max 2, min 1
        int c = nums[nums.length - 3] - nums[1];
        // 4. upd max 3, min 0
        int d = nums[nums.length - 4] - nums[0];
        return Math.min(Math.min(a, b), Math.min(c, d));
    }
}
