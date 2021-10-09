package binarysearch;

public class IndexWithEqualLeftAndRightSum {
    public int solve(int[] nums) {
        int rv = 0;
        for (int num : nums) rv += num;

        int lv = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > 0) lv += nums[i - 1];
            rv -= nums[i];
            if (rv == lv) return i;
        }
        return rv == lv ? 0 : -1;
    }
}
