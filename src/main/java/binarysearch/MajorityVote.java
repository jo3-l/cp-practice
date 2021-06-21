package binarysearch;

import java.util.Arrays;

public class MajorityVote {
    public int solve(int[] nums) {
        if (nums.length == 0) return -1;
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return nums[0] == nums[1] ? nums[0] : -1;
        Arrays.sort(nums);
        int h = nums.length >> 1;
        return nums[h] == nums[h + 1] ? nums[h] : -1;
    }
}
