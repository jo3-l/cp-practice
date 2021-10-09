package binarysearch;

public class InsertionIndexInSortedList {
    public int solve(int[] nums, int target) {
        int hi = nums.length - 1;
        int lo = 0;
        while (lo < hi) {
            int mid = (hi + lo) >> 1;
            int v = nums[mid];
            if (v <= target) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        if (nums[lo] > target) return lo;
        return lo + 1;
    }
}
