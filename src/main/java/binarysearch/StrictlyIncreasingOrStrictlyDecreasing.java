package binarysearch;

public class StrictlyIncreasingOrStrictlyDecreasing {
    public boolean solve(int[] nums) {
        if (nums.length < 2) return true;
        if (nums[0] == nums[1]) return false;
        boolean isIncr = nums[0] < nums[1];
        for (int i = 1; i < nums.length; i++) {
            if ((isIncr && nums[i] <= nums[i - 1])
                    || (!isIncr && nums[i] >= nums[i - 1])) return false;
        }
        return true;
    }
}
