package binarysearch;

public class KthMissingNumber {
    public int solve(int[] nums, int k) {
        k++;
        if (nums.length == 1) return nums[0] + k;
        for (int i = 0; i < nums.length - 1; i++) {
            int gap = nums[i + 1] - nums[i] - 1;
            if (gap == 0) continue;
            if (gap >= k) return nums[i] + k;
            k -= gap;
        }
        return nums[nums.length - 1] + k;
    }
}
