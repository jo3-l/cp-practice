package binarysearch;

public class SmallestPairSumWithDistanceConstraint {
    public int solve(int[] nums) {
        int slowMin = nums[0];
        int ans = Integer.MAX_VALUE;
        for (int i = 2; i < nums.length; i++) {
            ans = Math.min(ans, nums[i] + slowMin);
            slowMin = Math.min(slowMin, nums[i - 1]);
        }
        return ans;
    }
}
