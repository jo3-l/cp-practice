package binarysearch;

public class SumOfTwoNumbersWithSortedList {
    public boolean solve(int[] nums, int k) {
        int hi = nums.length - 1;
        int lo = 0;
        while (lo < hi) {
            int total = nums[lo] + nums[hi];
            if (total == k) return true;
            if (total < k) lo++;
            else hi--;
        }
        return false;
    }
}
