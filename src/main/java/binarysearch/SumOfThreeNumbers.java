package binarysearch;

import java.util.Arrays;

public class SumOfThreeNumbers {
    public boolean solve(int[] nums, int k) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int cur = nums[i];
            int lo = 0;
            int hi = nums.length - 1;
            while (lo < hi && lo < i && hi != i) {
                int t = cur + nums[hi] + nums[lo];
                if (t > k) {
                    hi--;
                } else if (t == k) {
                    return true;
                } else {
                    lo++;
                }
            }
        }
        return false;
    }
}
