package binarysearch;

public class VerifyMaxHeap {
    public boolean solve(int[] nums) {
        for (int i = 0; i < nums.length >> 1; i++) {
            int ii = (i << 1) + 1;
            if (ii >= nums.length) break;
            if (nums[i] < nums[ii] || (ii + 1 < nums.length && nums[i] < nums[ii + 1])) return false;
        }
        return true;
    }
}
