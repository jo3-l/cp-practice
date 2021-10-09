package binarysearch;

public class EqualizeList {
    public int solve(int[] nums, int[] costs) {
        if (nums.length == 0) return 0;
        int lo = Integer.MAX_VALUE, hi = Integer.MIN_VALUE;
        for (int n : nums) {
            lo = Math.min(lo, n);
            hi = Math.max(hi, n);
        }
        while (lo < hi) {
            int mid = (lo + hi + 1) >>> 1;
            if (cmp(mid - 1, nums, costs) > cmp(mid, nums, costs)) {
                lo = mid;
            } else {
                hi = mid - 1;
            }
        }
        return cmp(lo, nums, costs);
    }

    private int cmp(int j, int[] nums, int[] costs) {
        int c = 0;
        for (int i = 0; i < nums.length; i++) {
            int diff = Math.abs(nums[i] - j);
            c += costs[i] * diff;
        }
        return c;
    }
}
