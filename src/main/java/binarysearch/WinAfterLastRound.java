package binarysearch;

import java.util.Arrays;

public class WinAfterLastRound {
    public int solve(int[] nums) {
        if (nums.length < 2) return nums.length;
        Arrays.sort(nums);
        int lo = 0;
        int hi = nums.length - 1;
        int res = nums.length;
        while (lo < hi) {
            int mid = (lo + hi) >> 1;
            if (nums[mid] + nums.length < nums[nums.length - 1] || !canWin(nums, mid)) {
                lo = mid + 1;
            } else {
                hi = res = mid;
            }
        }
        return nums.length - res;
    }

    private boolean canWin(int[] nums, int i) {
        for (int j = 0, sub = 1; j < nums.length; j++) {
            if (i == j) continue;
            if (nums[j] - sub > nums[i]) return false;
            sub++;
        }
        return true;
    }
}
