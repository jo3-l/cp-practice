package binarysearch;

public class MaxSumOfTwoNonOverlappingLists {
    public int solve(int[] nums, int a, int b) {
        return solve(nums, a, b, true);
    }
    public int solve(int[] nums, int a, int b, boolean recv) {
        int[] as = go(nums, a);
        int[] bs = go(nums, b);
        int[] ms = new int[bs.length]; // ms[i] = max(bs[i..])
        ms[bs.length - 1] = bs[bs.length - 1];
        for (int i = bs.length - 2; i >= 0; i--) ms[i] = Math.max(bs[i], ms[i + 1]);
        int res = Integer.MIN_VALUE;
        for (int i = 0, s = a; i < as.length; i++, s++) {
            if (s >= ms.length) break;
            res = Math.max(res, as[i] + ms[s]);
        }
        int cv = res == Integer.MIN_VALUE ? 0 : res;
        return recv ? Math.max(cv, solve(nums, b, a, false)) : cv;
    }

    private int[] go(int[] nums, int len) {
        int[] sums = new int[nums.length - len + 1];
        for (int i = 0; i < len; i++) sums[0] += nums[i];
        for (int lo = 1, hi = len; hi < nums.length; lo++, hi++) {
            sums[lo] = sums[lo - 1] - nums[lo - 1] + nums[hi];
        }
        return sums;
    }
}
