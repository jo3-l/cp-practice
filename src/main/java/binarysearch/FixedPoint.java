package binarysearch;

public class FixedPoint {
    public int solve(int[] nums) {
        int hi = nums.length - 1;
        int lo = 0;
        int res = -1;
        while (lo <= hi) {
            int mid = (hi + lo) >> 1;
            if (nums[mid] > mid) {
                hi = mid - 1;
            } else if (nums[mid] == mid) {
                res = mid;
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }

        return res;
    }
}
