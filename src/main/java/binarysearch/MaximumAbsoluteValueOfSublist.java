package binarysearch;

public class MaximumAbsoluteValueOfSublist {
    public int solve(int[] nums) {
        int cur = 0;
        int max = 0, min = 0;
        int ans = 0;
        for (int n : nums) {
            cur += n;
            ans = Math.max(ans, Math.max(Math.abs(cur - max), Math.abs(cur - min)));
            max = Math.max(max, cur);
            min = Math.min(min, cur);
        }
        return ans;
    }
}
