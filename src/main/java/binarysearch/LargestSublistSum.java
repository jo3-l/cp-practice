package binarysearch;

public class LargestSublistSum {
    public int solve(int[] nums) {
        int best = Integer.MIN_VALUE;
        int min = 0;
        int cur = 0;
        for (int n : nums) {
            cur += n;
            best = Math.max(best, cur - min);
            min = Math.min(min, cur);
        }
        return best;
    }
}
