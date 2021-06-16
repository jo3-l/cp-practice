package binarysearch;

public class KPrefix {
    public int solve(int[] nums, int k) {
        int n = 0;
        for (int num : nums) n += num;

        for (int j = nums.length - 1; j >= 0; j--) {
            if (n <= k) return j;
            n -= nums[j];
        }

        return -1;
    }
}
